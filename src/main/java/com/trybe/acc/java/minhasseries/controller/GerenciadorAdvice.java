package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.DataError;
import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
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

  @ExceptionHandler(SerieNaoEncontradaException.class)
  public ResponseEntity<DataError> notFound(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new DataError(exception.getMessage()));
  }

  @ExceptionHandler({
      SerieExistenteException.class,
      EpisodioExistenteException.class
  })
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
