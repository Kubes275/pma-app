package sk.jra.pmaapp.utility.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sk.jra.pmaapp.data.enums.InvoiceUnits;

@AllArgsConstructor
@Getter
public class InvoiceItem {

  private Long id;
  private String name;
  private InvoiceItemTariff tariff;
  private InvoiceUnits unit;
}
