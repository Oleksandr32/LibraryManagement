package com.project.librarymanagement.exception;

/**
 * Created by Oleksandr Lysun on 01.01.2018.
 * Our own exception for our application.
 */
public class ApplicationException extends Exception {
    /**
     * Default constructor
     */
    public ApplicationException() {
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
