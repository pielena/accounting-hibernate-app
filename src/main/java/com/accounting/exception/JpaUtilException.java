package com.accounting.exception;

public class JpaUtilException extends RuntimeException {

    public JpaUtilException(String message, Throwable cause) {
        super(message, cause);
    }
}