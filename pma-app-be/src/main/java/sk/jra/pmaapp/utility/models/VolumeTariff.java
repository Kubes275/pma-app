package sk.jra.pmaapp.utility.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VolumeTariff extends InvoiceItemTariff {

  private double volume;
  private double pricePerUnit;

  @Override
  public double calculatePrice() {
    return volume * pricePerUnit;
  }
}
