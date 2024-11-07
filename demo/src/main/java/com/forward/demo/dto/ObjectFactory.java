package com.forward.demo.dto;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public CompraRequest createYourRequest() {
        return new CompraRequest();
    }

    public CompraRequest createYourResponse() {
        return new CompraRequest();
    }
}