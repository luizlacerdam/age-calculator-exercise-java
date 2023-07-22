package com.betrybe.calcuradoradeidade.service;

import com.betrybe.calcuradoradeidade.exception.FutureDateException;
import com.betrybe.calcuradoradeidade.exception.InvalidSyntaxDateException;
import com.betrybe.calcuradoradeidade.exception.NonNumericDateException;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

/**
 * Aqui nessa classe devem ser implementados os métodos para atender aos requisitos do exercício,
 * sinta-se à vontade para criar métodos privados para te auxiliar nas validações.
 */
@Service
public class AgeCalculatorService {

  /**
   * Constructor.
   */
  public int calculateAge(String dateString) {
    validateDateIsNumeric(dateString);
    validateSyntax(dateString);
    LocalDate dataInicial = LocalDate.parse(dateString);
    LocalDate dataFinal = LocalDate.now();
    Period intervalo = Period.between(dataInicial, dataFinal);
    if (intervalo.getYears() < 0) {
      throw new FutureDateException("This is a future date.");
    }
    return intervalo.getYears();
  }

  private void validateSyntax(String date) throws InvalidSyntaxDateException {
    String[] dateBlocks = date.split("-");
    if (dateBlocks.length != 3) {
      throw new InvalidSyntaxDateException("Invalid date format. Expected aa-mm-dd.");
    }
    String year = dateBlocks[0];
    String month = dateBlocks[1];
    String day = dateBlocks[2];
    if (year.length() != 4 || month.length() != 2 || day.length() != 2) {
      throw new InvalidSyntaxDateException("Invalid date format. Expected aa-mm-dd.");
    }
  }

  private void validateDateIsNumeric(String date) throws NonNumericDateException {
    String[] dateBlocks = date.split("-");
    for (String block : dateBlocks) {
      try {
        Integer.parseInt(block);
      } catch (NumberFormatException e) {
        throw new NonNumericDateException("Date should be in numeric format.");
      }
    }
  }

  public int calculateAgeWithDefault(String date, int defaultAge) {
    return defaultAge;
  }
}
