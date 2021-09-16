package com.zuhlke.processor.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }

    public BusinessException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
