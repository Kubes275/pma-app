package sk.jra.pmaapp.utility.models;

public record ElectricityPriceRate(
  long id,
  String electricitySupplRate,
  String electricityDistributionRate,
  int customerId,
  double electricityPrice,
  double electricityMonthlyRate,
  double electricityExiseRate,
  double electricityDistributionVolumeRate,
  double electricityDistributionLossesRate,
  double operatingSystemRate,
  double systemServicesRate,
  double contributionToNuclearFundRate,
  double fixedMonthlyRate
) {
}
