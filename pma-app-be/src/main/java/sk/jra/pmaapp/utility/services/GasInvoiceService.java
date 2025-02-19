package sk.jra.pmaapp.utility.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import sk.jra.pmaapp.utility.models.ElectricityPriceRate;
import sk.jra.pmaapp.utility.models.GasPriceRate;
import sk.jra.pmaapp.utility.models.UtilityBillInput;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class GasInvoiceService {

  private GasPriceRate gasPriceRate;

  @PostConstruct
  public void init() {
    log.info("Initializing electricity payments service...");
    gasPriceRate = new GasPriceRate(
      1, 2024, "D1", 1, 1, 0.977, 0.0344,1.5,0.0277,2.05, 0.00203, 0
    );



  }

  public void calculateGasInvoice(UtilityBillInput utilityBillInput) {
    // Calculate gas invoice



    // STAV MERACOV
    //TODO  dotahoať stav meracov z DB
  }
}
