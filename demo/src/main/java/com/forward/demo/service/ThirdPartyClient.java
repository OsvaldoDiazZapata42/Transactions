package com.forward.demo.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.common.crypto.Merlin;
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

        // Define WS-Security actions
        outProps.put(WSHandlerConstants.ACTION,
                     WSHandlerConstants.TIMESTAMP + " " + 
                     WSHandlerConstants.USERNAME_TOKEN + " " +
                     WSHandlerConstants.SIGNATURE + " " + 
                     WSHandlerConstants.ENCRYPT);

        // UsernameToken setup
        outProps.put(WSHandlerConstants.USER, wsUsername);
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, UsernamePasswordCallbackHandler.class.getName());

        // Directly specify keystore properties
        outProps.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
        outProps.put(WSHandlerConstants.SIGNATURE_USER, signatureAlias);
        outProps.put(WSHandlerConstants.ENC_KEY_ID, "DirectReference");
        outProps.put(WSHandlerConstants.ENCRYPTION_USER, encryptionAlias);

        // Add keystore details directly (without using client-crypto.properties)
        Map<String, String> cryptoProps = new HashMap<>();
        cryptoProps.put("org.apache.ws.security.crypto.provider", Merlin.class.getName());
        cryptoProps.put("org.apache.ws.security.crypto.merlin.keystore.type", "pkcs12");
        cryptoProps.put("org.apache.ws.security.crypto.merlin.keystore.password", keystorePassword);
        cryptoProps.put("org.apache.ws.security.crypto.merlin.keystore.file", keystoreFile);

        // Pass the crypto properties directly to CXF
        outProps.put(WSHandlerConstants.SIG_PROP_REF_ID, "cryptoProps");
        outProps.put(WSHandlerConstants.ENC_PROP_REF_ID, "cryptoProps");
        outProps.put("cryptoProps", cryptoProps);

        // Define the signature and encryption algorithms
        //outProps.put(WSHandlerConstants.SIG_ALGO, WSConstants.RSA_SHA512);
        outProps.put(WSHandlerConstants.ENC_SYM_ALGO, WSConstants.AES_256); // AES-256 encryption for the message body

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        client.getEndpoint().getOutInterceptors().add(wssOut);
    }
}
