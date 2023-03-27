package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.DataError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe GerenciadorAdvice.
 * 
 */
@ControllerAdvice
public class GerenciadorAdvice {

  @ExceptionHandler()
  public ResponseEntity<DataError> notFound(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new DataError(exception.getMessage()));
  }

  @ExceptionHandler()
  public ResponseEntity<DataError> conflict(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new DataError(exception.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<DataError> internalServerError(Exception e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new DataError("Erro inesperado"));
  }

}
