package com.bank.validation;

import com.bank.model.ChequeProcessingRequest;
import java.util.Base64;
import java.util.List;

public class ChequeValidator {

    public static void validate(ChequeProcessingRequest r) {
        
        if (r == null) {
            throw new IllegalArgumentException("Request body is missing");
        }

        /* ---------- BASIC FIELDS ---------- */

        validateFixedDigits(r.getChequeNumber(), 6, "Cheque Number");
        validateFixedDigits(r.getRoutingNumber(), 9, "Routing Number");
        validateFixedDigits(r.getDraweeAccountNumber(), 10, "Drawee Account Number");

        validateMaxDigits(r.getCreditAccountNumber(), 16, "Credit Account Number");

        validateUnixDate(r.getPresentmentDate(), "Presentment Date");
        validateUnixDate(r.getSettlementDate(), "Settlement Date");
        validateUnixDate(r.getChequeDate(), "Cheque Date");

        validateLength(r.getType(), 10, "Type");
        validateAmount(r.getAmount(), "Amount");
        validateAmount(r.getPunchedAmount(), "Punched Amount");

        validateLength(r.getDepositMachineId(), 16, "Deposit Machine Id");
        validateBoolean(r.getPostingRequired(), "Posting Required");

        validateFixedDigits(r.getCorporateId(), 10, "Corporate ID");
        validateLength(r.getCorporateName(), 50, "Corporate Name");
        validateLength(r.getPostingTransactionId(), 20, "Posting Transaction Id");
        /* ---------- IMAGE VALIDATION ---------- */

        if (r.getImage() == null) {
            throw new IllegalArgumentException("Image object missing");
        }

        decodeBase64(r.getImage().getFront(), "Front Image");
        decodeBase64(r.getImage().getRear(), "Rear Image");

        /* ---------- UTILITY ---------- */

        if (r.getUtility() != null) {
            validateLength(r.getUtility().getReferenceNumber(), 21, "Reference Number");
            validateLength(r.getUtility().getConsumerNumber(), 20, "Consumer Number");
        }

        /* ---------- COLLATERAL ---------- */

        if (r.getCollateral() != null) {
            validateLength(r.getCollateral().getLoanAccountNumber(), 16, "Loan Account Number");
            validateLength(r.getCollateral().getOriginationId(), 20, "Origination Id");
            validateLength(r.getCollateral().getAgreementId(), 20, "Agreement Id");
            validateLength(r.getCollateral().getInstallmentNumber(), 20, "Installment Number");
        }

        /* ---------- NARRATIONS ---------- */

        List<String> narrations = r.getNarrations();
        if (narrations != null) {
            for (String s : narrations) {
                validateAlphaNumeric(s, 50, "Narration");
            }
        }
    }

    /* ================= HELPER METHODS ================= */

    private static void validateFixedDigits(String value, int length, String field) {
        if (value == null || !value.matches("\\d{" + length + "}")) {
            throw new IllegalArgumentException(field + " must be " + length + " digits");
        }
    }

    private static void validateMaxDigits(String value, int max, String field) {
        if (value == null || !value.matches("\\d{1," + max + "}")) {
            throw new IllegalArgumentException(field + " max " + max + " digits");
        }
    }

    private static void validateLength(String value, int max, String field) {
        if (value == null || value.length() > max) {
            throw new IllegalArgumentException(field + " max length " + max);
        }
    }

    private static void validateAmount(String value, String field) {
        if (value == null || !value.matches("\\d{1,8}\\.\\d{2}")) {
            throw new IllegalArgumentException(field + " format invalid (8+2)");
        }
    }

    private static void validateUnixDate(String value, String field) {
        if (value == null || !value.matches("\\d{13}")) {
            throw new IllegalArgumentException(field + " must be Unix timestamp");
        }
    }

    private static void validateBoolean(String value, String field) {
        if (!"TRUE".equalsIgnoreCase(value) && !"FALSE".equalsIgnoreCase(value)) {
            throw new IllegalArgumentException(field + " must be TRUE or FALSE");
        }
    }

    private static void validateAlphaNumeric(String value, int max, String field) {
        if (value == null || value.length() > max || !value.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException(field + " invalid");
        }
    }

    private static byte[] decodeBase64(String value, String field) {
        try {
            return Base64.getDecoder().decode(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(field + " Base64 decode failed");
        }
    }
}
