package com.producter.playermanager.exception;

import com.producter.playermanager.exception.generic.GenericExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlayerCountLimitExceededException extends RuntimeException{

    public PlayerCountLimitExceededException(String message) {
        super(message);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> notFoundException(NotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenericExistException.class)
    protected ResponseEntity<?> genericExistException(GenericExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}