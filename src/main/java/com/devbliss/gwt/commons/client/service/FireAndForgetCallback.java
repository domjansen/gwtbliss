package com.devbliss.gwt.commons.client.service;

import org.fusesource.restygwt.client.Method;

/**
 * Callback for operations where we do not care for the response.
 * 
 * @author hschuetz
 * 
 * @param <T>
 */
public class FireAndForgetCallback<T> extends SimpleMethodCallback<T> {

    @Override
    public void onSuccess(Method method, T response) {
        // no op
    }

}
