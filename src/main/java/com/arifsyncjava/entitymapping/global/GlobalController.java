package com.arifsyncjava.entitymapping.global;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

public class GlobalController implements ResponseBodyAdvice<Response> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return false;
    }

    @Override
    public Response beforeBodyWrite(Response body, MethodParameter returnType,
                                    MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                    ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }





}
