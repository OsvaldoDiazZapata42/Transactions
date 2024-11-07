package com.forward.demo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forward.demo.dto.CompraRequest;
import com.forward.demo.service.MyWebServiceClient;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final MyWebServiceClient client;

    public TransactionController(MyWebServiceClient client) {
        this.client = client;
    }

    @PostMapping("/sendTransaction")
    public ResponseEntity<Object> sendTransaction(@RequestBody CompraRequest  transactionData) {
        try {
            // Convert TransactionData to XML format
            //String xmlData = JsonToXmlConverter.convertRecordToXml(transactionData);

            return ResponseEntity.ok().body(client.sendRequest(transactionData));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error sending transaction: " + e.getMessage());
        }
    }
}