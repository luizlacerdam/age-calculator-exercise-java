package com.betrybe.calcuradoradeidade.exception;

/**
 * Classe que verifica se o parametro é numérico.
 */
public class NonNumericDateException  extends RuntimeException {

  /**
   * Construtor da classe.
   */
  public NonNumericDateException(String message) {
    super(message);
  }
}
