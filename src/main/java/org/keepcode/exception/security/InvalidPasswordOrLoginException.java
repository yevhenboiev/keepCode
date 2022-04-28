package org.keepcode.exception.security;

public class InvalidPasswordOrLoginException extends RuntimeException {

    public InvalidPasswordOrLoginException() {
        super("Invalid login or password");
    }
}
