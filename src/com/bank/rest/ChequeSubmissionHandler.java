package com.bank.rest;

import com.bank.model.ApiResponse;
import com.bank.model.ChequeProcessingRequest;
import com.bank.model.ChequeSubmissionRequest;
import com.bank.service.ChequeSubmissionService;
import com.bank.service.impl.ChequeSubmissionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class ChequeSubmissionHandler implements HttpHandler {

    private final ObjectMapper mapper = new ObjectMapper();
    private final ChequeSubmissionService service = new ChequeSubmissionServiceImpl();
   
    @Override
    public void handleRequest(HttpServerExchange exchange) {
    	
    	String clientIpCurrent = exchange.getSourceAddress()
                .getAddress()
                .getHostAddress();
    	      
       String clientIp;
        if (clientIpCurrent != null && !clientIpCurrent.isEmpty()) {
            clientIp = clientIpCurrent.split(",")[0].trim(); // first IP is real client
            System.out.println("actual Ip : "+clientIp);
        } else {
            clientIp = exchange.getSourceAddress().getAddress().getHostAddress();
        }

        
        if(!clientIp.startsWith("192.168."))
        {
        	 exchange.setStatusCode(403);
        	 exchange.getResponseSender().send("Not Authorized ,Invalid IP adress");
        	 return; 
        }
                         
//        String clientIp = exchange.getRequestHeaders().getFirst("Client-IP");
//        System.out.println("Client ID from Header: " + clientIp);
       
 
        
        String channelId = exchange.getRequestHeaders().getFirst("Channel-Id");
        System.out.println("Client ID from Header: " + channelId);
      if(channelId.equals("CheckDepositChannel"))
      {	  
        exchange.getRequestReceiver().receiveFullString((ex, body) -> {
            try {
            	  
            	ChequeSubmissionRequest wrapper =
            		    mapper.readValue(body, ChequeSubmissionRequest.class);

            		ChequeProcessingRequest request =
            		    wrapper.getChequeProcessing();

                service.process(request);

                ApiResponse response =
                        new ApiResponse("SUCCESS", "Cheque submitted successfully");
                  
                ex.setStatusCode(200);
                ex.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                ex.getResponseSender().send(response.toJson());

            } catch (IllegalArgumentException e) {

                ApiResponse response =
                        new ApiResponse("FAILED", e.getMessage());

                ex.setStatusCode(400);
                ex.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                ex.getResponseSender().send(response.toJson());

            } catch (Exception e) {

                e.printStackTrace();
       
                ApiResponse response =
                        new ApiResponse("ERROR", "Internal server error");

                ex.setStatusCode(500);
                ex.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                ex.getResponseSender().send(response.toJson());
            }
        });
      }
      else {
    	 exchange.setStatusCode(404);
    	 exchange.getResponseSender().send("Not Authorized ,Invalid Chaneel Id");
    	 return; 
      }
    }
}
