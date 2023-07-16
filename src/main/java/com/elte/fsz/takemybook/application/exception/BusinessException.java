package com.elte.fsz.takemybook.application.exception;

public class BusinessException  extends RuntimeException{
    private final String errorCode;
    private final String errorMessage;

    public BusinessException (String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
