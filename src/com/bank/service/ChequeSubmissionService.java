package com.bank.service;

import com.bank.model.ChequeProcessingRequest;

public interface ChequeSubmissionService {
	
    void process(ChequeProcessingRequest request) throws Exception;
    
}
