package sk.jra.pmaapp.utility.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MonthlyTariff extends InvoiceItemTariff {

  private double amount;
  private double pricePerMonth;

  @Override
  public double calculatePrice() {
    return amount * pricePerMonth;
  }
}
