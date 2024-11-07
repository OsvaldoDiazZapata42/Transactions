package com.forward.demo.service;

import java.io.IOException;
import java.security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.support.CryptoFactoryBean;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.soap.security.wss4j.callback.KeyStoreCallbackHandler;

@Configuration
public class WebServiceSecurityConfig {

    //todo  revisar las credenciales
    private final String sign_user = "testZonaVirtual";
    private final String enc_user = "testZonaVirtual"; 
    private final String secure_pass = "testZonaVirtual.2020";

    @Bean
    public Wss4jSecurityInterceptor securityInterceptorEncryption() throws Exception {

        Security.removeProvider("ApacheXMLDSig");
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        // CustomLoggingInterceptor securityInterceptor = new
        // CustomLoggingInterceptor();

        // set security actions
        // Solo encrypta
        //securityInterceptor.setSecurementActions("Encrypt");
        //securityInterceptor.setSecurementActions("Signature");
        securityInterceptor.setSecurementActions("Encrypt Signature Timestamp");

        // sign the request
        securityInterceptor.setSecurementSignatureUser(sign_user);
        securityInterceptor.setSecurementPassword(secure_pass);

        securityInterceptor.setSecurementSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha512");
        //securityInterceptor.setSecurementSignatureDigestAlgorithm("http://www.w3.org/2001/04/xmlenc#sha512");
        securityInterceptor.setEnableRevocation(false);
        //securityInterceptor.setSecurementSignatureParts("{}{http://schemas.xmlsoap.org/soap/envelope/}Body;{}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp");
        securityInterceptor.setSecurementSignatureParts("{}{http://schemas.xmlsoap.org/soap/envelope/}Body;");

        securityInterceptor.setSecurementSignatureKeyIdentifier("DirectReference");

        securityInterceptor.setSecurementSignatureCrypto(getCryptoFactoryBean().getObject());

        // encrypt the request
        securityInterceptor.setSecurementEncryptionUser(enc_user);
        securityInterceptor.setSecurementEncryptionCrypto(getCryptoFactoryBean().getObject());
        securityInterceptor.setSecurementEncryptionParts("Body");
        securityInterceptor.setSecurementEncryptionSymAlgorithm("http://www.w3.org/2001/04/xmlenc#aes256-cbc");

        securityInterceptor.setValidationActions("Timestamp Signature Encrypt");
        //securityInterceptor.setValidationActions("Encrypt");
        //securityInterceptor.setValidationActions("Signature");
        securityInterceptor.setValidationDecryptionCrypto(getCryptoFactoryBean().getObject());
        securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
        securityInterceptor.setValidationSignatureCrypto(getCryptoFactoryBean().getObject());

        securityInterceptor.afterPropertiesSet();

        return securityInterceptor;

    }

    @Bean
    public CryptoFactoryBean getCryptoFactoryBean() throws IOException {
        CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStorePassword("J%xY1eaPjnug\\v");
        cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("cert/certificado.pfx"));
        return cryptoFactoryBean;
    }

    @Bean
    public KeyStoreCallbackHandler securityCallbackHandler(){
        KeyStoreCallbackHandler callbackHandler = new KeyStoreCallbackHandler();
        callbackHandler.setPrivateKeyPassword("J%xY1eaPjnug\\v");
        return callbackHandler;
    }

    /*@Bean
    public CryptoFactoryBean getDecryptoFactoryBean() throws IOException {
        CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
        cryptoFactoryBean.setKeyStorePassword(secure_pass);
        cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("cert/certificado.pfx"));//client.jks -- classpath:decryption-keystore.jks
        return cryptoFactoryBean;
    }*/


    @Bean
    public WebServiceTemplate webServiceTemplate() throws Exception {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setInterceptors(new ClientInterceptor[] { securityInterceptorEncryption() });
        webServiceTemplate.setMarshaller(marshaller()); // Set the marshaller
        webServiceTemplate.setUnmarshaller(marshaller());
        webServiceTemplate.setMessageSender(httpComponentsMessageSender());
        return webServiceTemplate;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // Set the package to scan for your generated JAXB classes
        marshaller.setContextPath("com.forward.demo.dto");
        return marshaller;
    }

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
        messageSender.setConnectionTimeout(5000);
        messageSender.setReadTimeout(5000);
        return messageSender;
    }

}

