package com.forward.demo.service;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

@Component
public class UsernamePasswordCallbackHandler implements CallbackHandler {

    @Value("${ws.security.password}")
    private String wsPassword;

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) callback;

                if ("testZonaVirtual".equals(pc.getIdentifier())) {
                    pc.setPassword(wsPassword);
                }
            }
        }
    }
}
