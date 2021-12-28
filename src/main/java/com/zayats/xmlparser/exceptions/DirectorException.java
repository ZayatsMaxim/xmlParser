package com.zayats.xmlparser.exceptions;

public class DirectorException extends Exception{
    public DirectorException() {
        super();
    }

    public DirectorException(String message) {
        super(message);
    }

    public DirectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DirectorException(Throwable cause) {
        super(cause);
    }
}
