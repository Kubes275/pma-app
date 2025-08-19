package sk.jra.pmaapp.utility.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.jra.pmaapp.common.utils.RequestMappings;
import sk.jra.pmaapp.utility.models.ElectricityInvoiceModel;
import sk.jra.pmaapp.utility.models.UtilityBillInput;
import sk.jra.pmaapp.utility.models.MeterStatus;
import sk.jra.pmaapp.utility.services.ElectricityPaymentsService;

import java.time.LocalDate;

import static sk.jra.pmaapp.utility.models.enums.UtilityType.ELECTRICITY;
import static sk.jra.pmaapp.utility.models.enums.UtilityUnit.KWH;

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
    MeterStatus startState = new MeterStatus(start, 2397, ELECTRICITY, KWH);
    MeterStatus endState = new MeterStatus(end, 2829, ELECTRICITY, KWH);
    UtilityBillInput input = new UtilityBillInput(startState, endState);
    return electricityPaymentsService.calculateElectricityPayments(input);
  }
}
