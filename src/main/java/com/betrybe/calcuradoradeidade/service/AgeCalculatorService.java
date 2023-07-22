package com.betrybe.calcuradoradeidade.service;

import com.betrybe.calcuradoradeidade.exception.FutureDateException;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

/**
 * Aqui nessa classe devem ser implementados os métodos para atender aos requisitos do exercício,
 * sinta-se à vontade para criar métodos privados para te auxiliar nas validações.
 */
@Service
public class AgeCalculatorService {
  public int calculateAge(String dateString) {
    LocalDate dataInicial = LocalDate.parse(dateString);
    LocalDate dataFinal = LocalDate.now();

    Period intervalo = Period.between(dataInicial, dataFinal);
    if (intervalo.getYears() < 0) {
      throw new FutureDateException("This is a future date.");
    }
    return intervalo.getYears();
  }

  public int calculateAgeWithDefault(String date, int defaultAge) {
    // TODO method implementation
    return -1;
  }
}
