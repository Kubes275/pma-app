package sk.jra.pmaapp.utility.models;

public record GasPriceRate(
  long id,
  int year,
  String gasTypeTariff,
  int customerId,
  int propertyId,
  double volumeConversionCoefficient,     // Objemové prepocitavacie cislo
  double gasTraderServicesVolumeRate,     // Sluzby obchodnika  - SOP (sadzba za odobraty plyn)
  double gasTraderServicesMonthRate,      // Sluzby obchodnika  - FMS (fixna mesacna sadzba)
  double gasDistributionVolumeRate,       // Distribucia - SOP (sadzba za odobraty plyn)
  double gasDistributionMonthRate,        // Distribucia - FMS (fixna mesacna sadzba)
  double transportRateVolumeRate,         // Transport - SOP (sadzba za odobraty plyn)
  double transportRateMonthRate           // Transport - FMS (fixna mesacna sadzba)
) {
}
