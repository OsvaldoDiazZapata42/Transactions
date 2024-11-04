package com.forward.demo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forward.demo.dto.CompraRequest;
import com.forward.demo.service.ThirdPartyClient;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final ThirdPartyClient thirdPartyClient;

    public TransactionController(ThirdPartyClient thirdPartyClient) {
         this.thirdPartyClient = thirdPartyClient;
    }

    @PostMapping("/sendTransaction")
    public ResponseEntity<String> sendTransaction(@RequestBody CompraRequest  transactionData) {
        try {
            // Convert TransactionData to XML format
            //String xmlData = JsonToXmlConverter.convertRecordToXml(transactionData);

            String response = thirdPartyClient.sendToThirdParty(transactionData);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error sending transaction: " + e.getMessage());
        }
    }
}