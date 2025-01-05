package sk.jra.pmaapp.utility.models;

public record InvoiceItemModel(
  String name,
  String unit,
  double unitPrice,
  double amount,
  double total
) {}
