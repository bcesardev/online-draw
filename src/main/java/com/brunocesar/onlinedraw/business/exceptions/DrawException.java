package com.brunocesar.onlinedraw.business.exceptions;

/**
 * DrawException
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
public class DrawException extends Exception {

    public DrawException() {
    }

    public DrawException(String message) {
        super(message);
    }

    public DrawException(String message, Throwable cause) {
        super(message, cause);
    }

    public DrawException(Throwable cause) {
        super(cause);
    }

    public DrawException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
