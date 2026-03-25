package com.bank.model;

import java.util.List;

public class ChequeProcessingRequest {

    private String actionType;
    private String chequeNumber;
    private String routingNumber;
    private String type;
    private String draweeAccountNumber;
    private String creditAccountNumber;
    private String amount;
    private String punchedAmount;
    private String chequeDate;
    private String presentmentDate;
    private String settlementDate;
    private String depositMachineId;
    private String postingRequired;
    private String postingTransactionId;

    private String corporateId;
    private String corporateName;

    private Image image;
    private Utility utility;
    private Collateral collateral;

    private List<String> narrations;

    // ===== IMAGE =====
    public static class Image {
        private String front;
        private String rear;

        public String getFront() { return front; }
        public void setFront(String front) { this.front = front; }

        public String getRear() { return rear; }
        public void setRear(String rear) { this.rear = rear; }
    }

    // ===== UTILITY =====
    public static class Utility {
        private String type;
        private String referenceNumber;
        private String consumerNumber;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getReferenceNumber() { return referenceNumber; }
        public void setReferenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
        }

        public String getConsumerNumber() { return consumerNumber; }
        public void setConsumerNumber(String consumerNumber) {
            this.consumerNumber = consumerNumber;
        }
    }

    // ===== COLLATERAL =====
    public static class Collateral {
        private String loanAccountNumber;
        private String originationId;
        private String agreementId;
        private String installmentNumber;

        public String getLoanAccountNumber() { return loanAccountNumber; }
        public void setLoanAccountNumber(String loanAccountNumber) {
            this.loanAccountNumber = loanAccountNumber;
        }

        public String getOriginationId() { return originationId; }
        public void setOriginationId(String originationId) {
            this.originationId = originationId;
        }

        public String getAgreementId() { return agreementId; }
        public void setAgreementId(String agreementId) {
            this.agreementId = agreementId;
        }

        public String getInstallmentNumber() { return installmentNumber; }
        public void setInstallmentNumber(String installmentNumber) {
            this.installmentNumber = installmentNumber;
        }
    }

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDraweeAccountNumber() {
		return draweeAccountNumber;
	}

	public void setDraweeAccountNumber(String draweeAccountNumber) {
		this.draweeAccountNumber = draweeAccountNumber;
	}

	public String getCreditAccountNumber() {
		return creditAccountNumber;
	}

	public void setCreditAccountNumber(String creditAccountNumber) {
		this.creditAccountNumber = creditAccountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPunchedAmount() {
		return punchedAmount;
	}

	public void setPunchedAmount(String punchedAmount) {
		this.punchedAmount = punchedAmount;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getPresentmentDate() {
		return presentmentDate;
	}

	public void setPresentmentDate(String presentmentDate) {
		this.presentmentDate = presentmentDate;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getDepositMachineId() {
		return depositMachineId;
	}

	public void setDepositMachineId(String depositMachineId) {
		this.depositMachineId = depositMachineId;
	}

	public String getPostingRequired() {
		return postingRequired;
	}

	public void setPostingRequired(String postingRequired) {
		this.postingRequired = postingRequired;
	}

	public String getPostingTransactionId() {
		return postingTransactionId;
	}

	public void setPostingTransactionId(String postingTransactionId) {
		this.postingTransactionId = postingTransactionId;
	}

	public String getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Utility getUtility() {
		return utility;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	public Collateral getCollateral() {
		return collateral;
	}

	public void setCollateral(Collateral collateral) {
		this.collateral = collateral;
	}

	public List<String> getNarrations() {
		return narrations;
	}

	public void setNarrations(List<String> narrations) {
		this.narrations = narrations;
	}

   
}
