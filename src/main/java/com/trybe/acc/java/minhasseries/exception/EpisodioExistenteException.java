package com.trybe.acc.java.minhasseries.exception;

/**
 * Classe EpisodioExistenteException.
 * 
 */
public class EpisodioExistenteException extends RuntimeException {

  private static final String message = "Episódio Existente";

  public EpisodioExistenteException() {
    super(message);
  }
  
}
