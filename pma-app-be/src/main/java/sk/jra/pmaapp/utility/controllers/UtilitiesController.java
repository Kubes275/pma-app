package sk.jra.pmaapp.utility.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.jra.pmaapp.common.utils.RequestMappings;
import sk.jra.pmaapp.utility.models.ElectricityInvoiceModel;
import sk.jra.pmaapp.utility.models.ElectricityPaymentInput;
import sk.jra.pmaapp.utility.models.ElectricityState;
import sk.jra.pmaapp.utility.services.ElectricityPaymentsService;

import java.time.LocalDate;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(RequestMappings.API_UTILITIES_URL)
public class UtilitiesController {


  private final ElectricityPaymentsService electricityPaymentsService;

  @GetMapping("")
  @ResponseStatus(HttpStatus.OK)
  public ElectricityInvoiceModel getElectricityPayments() {
    log.info("getElectricityPayments");
    LocalDate start = LocalDate.parse("2024-01-01");
    LocalDate end = LocalDate.parse("2024-03-06");
    ElectricityState startState = new ElectricityState(start, 2397);
    ElectricityState endState = new ElectricityState(end, 2829);
    ElectricityPaymentInput input = new ElectricityPaymentInput(startState, endState);
    return electricityPaymentsService.calculateElectricityPayments(input);
  }
}
