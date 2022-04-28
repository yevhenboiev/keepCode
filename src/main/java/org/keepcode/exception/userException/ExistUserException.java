package org.keepcode.exception.userException;

public class ExistUserException extends RuntimeException {

    public ExistUserException(String email) {
        super(email + "is exist, please send another email");
    }
}
