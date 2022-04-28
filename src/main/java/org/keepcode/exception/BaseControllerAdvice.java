package org.keepcode.exception;

import org.keepcode.exception.clientException.NotExistClientException;
import org.keepcode.exception.ticketException.NotExistTicketException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(NotExistClientException.class)
    public Object notExistClientException(NotExistClientException exception) {
        return response(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(NotExistTicketException.class)
    public Object notExistOrderException(NotExistTicketException exception) {
        return response(HttpStatus.NOT_FOUND, exception);
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
