package sk.jra.pmaapp.utility.models;

import java.util.List;

public record ElectricitySupplyModel(
  List<InvoiceItemModel> items,
  double totalPrice
) {
}
