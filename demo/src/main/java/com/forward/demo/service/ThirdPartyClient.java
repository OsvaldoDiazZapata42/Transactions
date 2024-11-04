package com.forward.demo.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.forward.demo.dto.CompraRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class ThirdPartyClient {

    @Value("${thirdparty.service.url}")
    private String serviceUrl;

    @Value("${ws.security.username}")
    private String wsUsername;

    @Value("${ws.security.password}")
    private String wsPassword;

    @Value("${ws.security.keystore.file}")
    private String keystoreFile;

    @Value("${ws.security.keystore.password}")
    private String keystorePassword;

    @Value("${ws.security.signature.alias}")
    private String signatureAlias;

    @Value("${ws.security.encryption.alias}")
    private String encryptionAlias;

    public String sendToThirdParty(CompraRequest request) throws Exception {
        // Configure the client factory
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ThirdPartyService.class);
        factory.setAddress(serviceUrl);

        // Create the client
        ThirdPartyService client = (ThirdPartyService) factory.create();
        Client proxyClient = ClientProxy.getClient(client);

        // Configure WS-Security with UsernameToken, signing, and encryption
        configureWSSecurity(proxyClient);

        // Send data to third-party service
        return client.compraProcesarSolicitud(request);
    }

    private void configureWSSecurity(Client client) {
        Map<String, Object> outProps = new HashMap<>();

        // WS-Security Actions: UsernameToken, Signature, and Encryption
        outProps.put(WSHandlerConstants.ACTION, 
                     WSHandlerConstants.USERNAME_TOKEN + " " + WSHandlerConstants.SIGNATURE + " " + WSHandlerConstants.ENCRYPT);
        
        // UsernameToken properties
        outProps.put(WSHandlerConstants.USER, wsUsername);
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, UsernamePasswordCallbackHandler.class.getName());

        // Keystore properties for signing and encryption
        outProps.put(WSHandlerConstants.SIG_PROP_FILE, "application.properties");
        outProps.put(WSHandlerConstants.ENC_PROP_FILE, "J%xY1eaPjnug\\v");

        // Alias settings for signing and encryption
        outProps.put(WSHandlerConstants.SIGNATURE_USER, signatureAlias);
        outProps.put(WSHandlerConstants.ENCRYPTION_USER, encryptionAlias);

        // Attach the WS-Security interceptor
        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        client.getEndpoint().getOutInterceptors().add(wssOut);
    }
}
