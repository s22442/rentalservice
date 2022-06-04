package com.pjatk.rentalservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class MovieAdvice {

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleExternalBadRequestException() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleExternalNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<String> handleExternalServerException() {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> handleConnectException() {
        return ResponseEntity.badRequest().build();
    }
}
