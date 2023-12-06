package sk.jra.pmaapp.controllers;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.jra.pmaapp.common.utils.RequestMappings;
import sk.jra.pmaapp.data.models.PaymentModel;
import sk.jra.pmaapp.data.models.PropertyModel;
import sk.jra.pmaapp.services.PaymentService;
import sk.jra.pmaapp.services.PropertiesService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(RequestMappings.API_PAYMENTS_URL)
public class PaymentsController {

  @Autowired
  PaymentService paymentService;

  @GetMapping("")
  @ResponseStatus(HttpStatus.OK)
  public List<PaymentModel> getAllPayments() {
    log.info("getAllPayments");
    return paymentService.getPayments();
  }

  @GetMapping("/{paymentId}")
  @ResponseStatus(HttpStatus.OK)
  public PaymentModel getPaymentDetail(
    @PathVariable @NotNull Long propertyId) {

    return null;
  }

}
