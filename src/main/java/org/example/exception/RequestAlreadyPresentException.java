package org.example.exception;

public class RequestAlreadyPresentException extends RuntimeException {
    public RequestAlreadyPresentException() {
    }

    public RequestAlreadyPresentException(String message) {
        super(message);
    }

    public RequestAlreadyPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestAlreadyPresentException(Throwable cause) {
        super(cause);
    }

    public RequestAlreadyPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
