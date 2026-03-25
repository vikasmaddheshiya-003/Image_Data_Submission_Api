package com.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChequeSubmissionRequest {

    @JsonProperty("cheque-processing")
    private ChequeProcessingRequest chequeProcessing;

    public ChequeProcessingRequest getChequeProcessing() {
        return chequeProcessing;
    }

    public void setChequeProcessing(ChequeProcessingRequest chequeProcessing) {
        this.chequeProcessing = chequeProcessing;
    }
    
}
