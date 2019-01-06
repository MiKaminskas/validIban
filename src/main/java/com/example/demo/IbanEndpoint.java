package com.example.demo;

import com.example.demo.IbanValidator;
import localhost._8080.iban.GetIbanDetailsRequest;
import localhost._8080.iban.GetIbanDetailsResponse;
import localhost._8080.iban.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class IbanEndpoint {


    IbanValidator validator;

    @Autowired
    public IbanEndpoint(IbanValidator validator) {
        this.validator = validator;
    }

    @PayloadRoot(namespace = "http://localhost:8080/iban", localPart = "GetIbanDetailsRequest")
    @ResponsePayload
    public GetIbanDetailsResponse processRequest(@RequestPayload GetIbanDetailsRequest request){

        GetIbanDetailsResponse response = new GetIbanDetailsResponse();

        Iban iban = new Iban();
        iban.setIban(request.getIban());
        iban.setIsValid(validator.ibanValid(request.getIban()));
        response.setIban(iban);

        return response;
    }
}
