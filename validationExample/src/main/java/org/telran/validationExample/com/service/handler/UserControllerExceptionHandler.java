package org.telran.validationExample.com.service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.telran.validationExample.com.exception.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UserControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity userNotFoundException(UserNotFoundException exception,
                                                HttpServletRequest request) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
