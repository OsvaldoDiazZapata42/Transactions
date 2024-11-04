package com.forward.demo.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToXmlConverter {

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static String convertRecordToXml(String transactionData) {
        try {
            // Convert the record to JSON node
            String jsonString = jsonMapper.writeValueAsString(transactionData);
            
            // Convert JSON node to XML
            return xmlMapper.writer().withRootName("Transaction").writeValueAsString(jsonMapper.readTree(jsonString));
        } catch (Exception e) {
            throw new RuntimeException("Error converting record to XML: " + e.getMessage(), e);
        }
    }
}