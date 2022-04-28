package org.keepcode.exception.subscriberException;

public class ExistSubscriberException extends RuntimeException {

    public ExistSubscriberException(String email) {
        super(email + "is exist, please send another email");
    }
}
