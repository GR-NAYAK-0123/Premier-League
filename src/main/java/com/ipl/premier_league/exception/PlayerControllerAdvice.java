package com.ipl.premier_league.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PlayerControllerAdvice {

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<?> handlePlayerNotFound(PlayerNotFoundException pnf){
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), pnf.getMessage(), "404 - Player Not Found");
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllTypeException(Exception e){
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in Execution");
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
