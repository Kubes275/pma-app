package sk.jra.pmaapp.utility.models;

import java.math.BigDecimal;

public record ElectricityInvoiceModel(
  double months,
  double eletricityVolume,
  BigDecimal eletricityPriceNoVat,
  BigDecimal vat,
  BigDecimal eletricityPriceTotal,
  ElectricitySupplyModel electricitySupplyModel,
  ElectricitySupplyModel distributionModel) {}
