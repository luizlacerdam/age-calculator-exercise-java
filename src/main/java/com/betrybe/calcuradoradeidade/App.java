package com.betrybe.calcuradoradeidade;

import com.betrybe.calcuradoradeidade.service.AgeCalculatorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring Boot bootstrapping.
 */
@SpringBootApplication
public class App {
  /**
   * main method.
   */
  public static void main(String[] args) {
    AgeCalculatorService ageCalculatorService = new AgeCalculatorService();
    System.out.println(ageCalculatorService.calculateAge("2000-03-20"));
//  SpringApplication.run(App.class, args);
  }
}
