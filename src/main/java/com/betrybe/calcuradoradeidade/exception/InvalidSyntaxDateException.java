package com.betrybe.calcuradoradeidade.exception;

/**
 * Classe de messagens de errors se parametro falta.
 */
public class InvalidSyntaxDateException extends RuntimeException {

  /**
   * Construtor da classe.
   */
  public InvalidSyntaxDateException(String message) {
    super(message);
  }
}
