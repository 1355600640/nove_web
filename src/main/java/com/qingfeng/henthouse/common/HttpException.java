package com.qingfeng.henthouse.common;

public class HttpException extends RuntimeException{
    protected String message;
    protected Integer httpStatusCode = 500;

    public String getErrorMessage() {
        return message;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

}
