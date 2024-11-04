package com.forward.demo.service;

import com.forward.demo.dto.CompraRequest;

@jakarta.jws.WebService(targetNamespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
public interface ThirdPartyService {

    @jakarta.jws.WebMethod(operationName = "compraProcesarSolicitud")
    String compraProcesarSolicitud(@jakarta.jws.WebParam(name = "compraProcesarSolicitud") CompraRequest request);
}
