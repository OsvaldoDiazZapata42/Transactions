package com.forward.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.forward.demo.dto.CompraRequest;

@Service
public class MyWebServiceClient extends WebServiceGatewaySupport {

    private final WebServiceTemplate webServiceTemplate;

    public MyWebServiceClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public Object sendRequest(CompraRequest requestPayload) {
        return webServiceTemplate.marshalSendAndReceive("https://www.txstestrbm.com:9990/CompraElectronica/Compra", requestPayload);
    }
}