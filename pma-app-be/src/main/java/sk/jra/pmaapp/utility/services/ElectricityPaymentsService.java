package sk.jra.pmaapp.utility.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import sk.jra.pmaapp.common.utils.DateUtils;
import sk.jra.pmaapp.utility.mappers.ElectricityInvoiceMapper;
import sk.jra.pmaapp.utility.models.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static sk.jra.pmaapp.data.enums.InvoiceUnits.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class ElectricityPaymentsService {

  private final DateUtils dateUtils;
  private final ElectricityInvoiceMapper electricityInvoiceMapper;

  ElectricityPriceRate electricityPriceRate;
  List<InvoiceItem> electricityItems;
  List<InvoiceItem> distributionItems;

  @PostConstruct
  public void init() {
    log.info("Initializing electricity payments service...");
    electricityPriceRate = new ElectricityPriceRate(
      1, "DD1", "D1", 1, 80.17, 1.5, 0, 13.24, 10.915, 15.9, 6.2976, 3.27, 6.31

    );



  }

    public ElectricityInvoiceModel calculateElectricityPayments(ElectricityPaymentInput input) {
      log.info("Calculating electricity payments...");

      //input validation
      // input date and consumptin can t be null

      double months = dateUtils.getMonthsBetweenDates(input.getPeriodStart().getDate(), input.getPeriodEnd().getDate());
      log.info("Months between dates: {}", months);

      // vypocet spotreby
      double consumptionKWh = input.getPeriodEnd().getMeterReadeing() - input.getPeriodStart().getMeterReadeing();
      double consumption = consumptionKWh / 1000;
      log.info("Consumption: {}", consumption);
      // vypocet ceny
      double price = 0;
      electricityItems = List.of(
        new InvoiceItem(1L, "Cena za elektrinu odobratá vo VT", new VolumeTariff(consumption, electricityPriceRate.electricityPrice()), MWH),
        new InvoiceItem(2L, "Mesačná platba za jedno odberné miesto", new MonthlyTariff(months, electricityPriceRate.electricityMonthlyRate()), MONTH),
        new InvoiceItem(3L, "Spotrebná daň z elektriny §7. 1j", new VolumeTariff(consumption, electricityPriceRate.electricityExiseRate()), MWH)
      );
      distributionItems = List.of(
        new InvoiceItem(4L, "Tarifa za distribuované množstvo elektriny", new VolumeTariff(consumption, electricityPriceRate.electricityDistributionVolumeRate()), MWH),
        new InvoiceItem(5L, "Tarifa za straty pri distribúcii elektriny", new VolumeTariff(consumption, electricityPriceRate.electricityDistributionLossesRate()), MWH),
        new InvoiceItem(6L, "Tarifa za prevádzkovanie systému", new VolumeTariff(consumption, electricityPriceRate.operatingSystemRate()), MWH),
        new InvoiceItem(7L, "Tarifa za systémové služby", new VolumeTariff(consumption, electricityPriceRate.systemServicesRate()), MWH),
        new InvoiceItem(8L, "Efektívna sadzba odvodu do Národného jadrového fondu", new VolumeTariff(consumption, electricityPriceRate.contributionToNuclearFundRate()), MWH),
        new InvoiceItem(9L, "Pevná mesačná platba za jedno odberné miesto", new VolumeTariff(months, electricityPriceRate.fixedMonthlyRate()), MONTH)
      );


      double elPrice = electricityItems.stream().mapToDouble(item -> item.getTariff().calculatePrice()).sum();
      log.info("Electricity price: {}", elPrice);
      double distributionPrice = distributionItems.stream().mapToDouble(item -> item.getTariff().calculatePrice()).sum();
      log.info("Distribution price: {}", distributionPrice);
      price = elPrice + distributionPrice;
      double vat = price * 0.2;
      double priceWithVAt = price + vat;
      BigDecimal displayPriceNoVat = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
      BigDecimal displayPrice = BigDecimal.valueOf(priceWithVAt).setScale(2, RoundingMode.HALF_UP);
      BigDecimal vatPrice = BigDecimal.valueOf(vat).setScale(2, RoundingMode.HALF_UP);


      log.info("Price: {}", displayPriceNoVat);
      // vypocet celkovej ceny

      ElectricitySupplyModel supplyModel = new ElectricitySupplyModel(electricityInvoiceMapper.mapInvoiceItemListToInvoiceItemModelList(electricityItems), elPrice);
      ElectricitySupplyModel distributionModel = new ElectricitySupplyModel(electricityInvoiceMapper.mapInvoiceItemListToInvoiceItemModelList(distributionItems), distributionPrice);

      return new ElectricityInvoiceModel(months, consumption, displayPriceNoVat, vatPrice, displayPrice, supplyModel, distributionModel);
    }



}