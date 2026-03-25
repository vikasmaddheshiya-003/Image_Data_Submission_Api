package com.bank.service.impl;

import java.util.Base64;

import com.bank.dao.ChequeSubmissionDAO;
import com.bank.model.ChequeProcessingRequest;
import com.bank.service.ChequeSubmissionService;
import com.bank.validation.ChequeValidator;

public class ChequeSubmissionServiceImpl
        implements ChequeSubmissionService {

    private final ChequeSubmissionDAO dao = new ChequeSubmissionDAO();

    @Override
    public void process(ChequeProcessingRequest req) throws Exception {
          ChequeValidator.validate(req);
        byte[] front =
            Base64.getDecoder().decode(req.getImage().getFront());

        byte[] rear  =
            Base64.getDecoder().decode(req.getImage().getRear());
              
        dao.insert(
            req.getActionType(),
            req.getChequeNumber(),
            front,
            rear
        );
        
    }
}

