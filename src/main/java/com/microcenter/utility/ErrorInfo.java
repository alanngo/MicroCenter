package com.microcenter.utility;

public class ErrorInfo
{
    private int errorCode;
    private String errorMessage;

    public ErrorInfo(){}
    public ErrorInfo(int errorCode, String errorMessage)
    {
        this();
        setErrorCode(errorCode);
        setErrorMessage(errorMessage);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
