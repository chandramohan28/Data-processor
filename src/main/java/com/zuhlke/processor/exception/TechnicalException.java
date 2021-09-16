package com.zuhlke.processor.exception;

public class TechnicalException extends RuntimeException {

    public TechnicalException(String errorMessage) {
        super(errorMessage);
    }

    public TechnicalException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
