package com.heimdallauth.utils.exceptions;

public class DownstreamServiceException extends RuntimeException{
    public final String message;
    public final String requestPath;


    public DownstreamServiceException(String message, String requestPath) {
        super(message);
        this.message = message;
        this.requestPath = requestPath;
    }
}
