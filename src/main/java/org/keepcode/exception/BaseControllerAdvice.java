package org.keepcode.exception;

import org.keepcode.exception.clientException.NotExistClientException;
import org.keepcode.exception.security.InvalidPasswordOrLoginException;
import org.keepcode.exception.security.JwtAuthenticationException;
import org.keepcode.exception.subscriberException.ExistSubscriberException;
import org.keepcode.exception.subscriberException.NotExistSubscriberException;
import org.keepcode.exception.ticketException.NotExistTicketException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleValidationExceptions(MethodArgumentNotValidException exception) {
        return response(HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(NotExistClientException.class)
    public Object notExistClientException(NotExistClientException exception) {
        return response(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(InvalidPasswordOrLoginException.class)
    public Object invalidPasswordOrLoginException(InvalidPasswordOrLoginException exception) {
        return response(HttpStatus.FORBIDDEN, exception);
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public Object jwtAuthenticationException(JwtAuthenticationException exception) {
        return response(HttpStatus.UNAUTHORIZED, exception);
    }

    @ExceptionHandler(NotExistTicketException.class)
    public Object notExistOrderException(NotExistTicketException exception) {
        return response(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(NotExistSubscriberException.class)
    public Object notExistSubscriberException(NotExistSubscriberException exception) {
        return response(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(ExistSubscriberException.class)
    public Object existSubscriberException(ExistSubscriberException exception) {
        return response(HttpStatus.BAD_REQUEST, exception);
    }

    private Object response(HttpStatus httpStatus, Exception exception) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();
        body.put("message", exception.getMessage());
        body.put("status", httpStatus.toString());
        body.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(body, httpHeaders, httpStatus);
    }
}
