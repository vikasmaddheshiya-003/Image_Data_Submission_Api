package com.bank.util;

import com.bank.model.ChequeProcessingRequest;

public class RequestValidator {

    public static void validate(ChequeProcessingRequest req) {

        if (req == null) {
            throw new IllegalArgumentException("Request body is missing");
        }

        if (req.getChequeNumber() == null || req.getChequeNumber().isBlank()) {
            throw new IllegalArgumentException("Cheque number is required");
        }

        if (req.getRoutingNumber() == null || req.getRoutingNumber().isBlank()) {
            throw new IllegalArgumentException("Routing number is required");
        }

        if (req.getImage() == null) {
            throw new IllegalArgumentException("Cheque images are required");
        }

        if (req.getImage().getFront() == null || req.getImage().getRear() == null) {
            throw new IllegalArgumentException("Front and rear images are required");
        }
    }
}
