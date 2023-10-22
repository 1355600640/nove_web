package com.qingfeng.henthouse.common;

public class MethodsErrorException extends HttpException {
    public MethodsErrorException(String message){
        this.httpStatusCode = 400;
        this.message = message;
    }
}
