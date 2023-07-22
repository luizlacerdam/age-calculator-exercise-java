package com.betrybe.calcuradoradeidade.controller;

import com.betrybe.calcuradoradeidade.dto.DateDto;
import com.betrybe.calcuradoradeidade.dto.ErrorMessageDto;
import com.betrybe.calcuradoradeidade.exception.FutureDateException;
import com.betrybe.calcuradoradeidade.service.AgeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe Controller do AgeCalculator.
 */
@RestController
@RequestMapping("/calculateAge")
public class AgeCalculatorController implements AgeCalculatorControllerInterface {
  AgeCalculatorService service;

  /**
   * Constructor.
   */
  @Autowired
  public AgeCalculatorController(AgeCalculatorService service) {
    this.service = service;
  }

  @Override
  @GetMapping()
  public ResponseEntity<DateDto> calculateAge(String date, String orDefaultAge) {
    DateDto ageDto = new DateDto(service.calculateAge(date));
    return ResponseEntity.ok(ageDto);
  }

  @ExceptionHandler({FutureDateException.class})
  public ResponseEntity<ErrorMessageDto> handlerUnprocessableEntity(RuntimeException exception) {
    return ResponseEntity.unprocessableEntity().body(new ErrorMessageDto(exception.getMessage()));
  }
}
