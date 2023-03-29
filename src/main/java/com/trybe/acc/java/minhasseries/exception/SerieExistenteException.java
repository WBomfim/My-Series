package com.trybe.acc.java.minhasseries.exception;

/**
 * Classe SerieExistenteException.
 * 
 */
public class SerieExistenteException extends RuntimeException {
  
  private static final String message = "Série Existente";

  public SerieExistenteException() {
    super(message);
  }
  
}
