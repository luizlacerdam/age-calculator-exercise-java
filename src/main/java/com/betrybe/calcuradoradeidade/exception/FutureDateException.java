package com.betrybe.calcuradoradeidade.exception;

/**
 * Classe de excessão para datas iniciais no futuro.
 */
public class FutureDateException extends RuntimeException {

  /**
   * Construtor da classe.
   */
  public FutureDateException(String message) {
    super(message);
  }
}
