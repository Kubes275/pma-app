package sk.jra.pmaapp.utility.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sk.jra.pmaapp.utility.models.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElectricityInvoiceMapper {

  @Mapping(source = "tariff", target = "total", qualifiedByName = "tariffToTotalPrice")
  @Mapping(source = "tariff", target = "amount", qualifiedByName = "tariffToAmount")
  @Mapping(source = "tariff", target = "unitPrice", qualifiedByName = "tariffToPrice")
  InvoiceItemModel mapInvoiceItemToInvoiceItemModel(InvoiceItem item);

  List<InvoiceItemModel> mapInvoiceItemListToInvoiceItemModelList(List<InvoiceItem> properties);

  @Named("tariffToTotalPrice")
  default Double tariffToTotalPrice(InvoiceItemTariff tariff) {
    return tariff.calculatePrice();
  }
  
  @Named("tariffToAmount")
  default Double tariffToAmount(InvoiceItemTariff tariff) {
    return switch (tariff) {
      case VolumeTariff volumeTariff -> volumeTariff.getVolume();
      case MonthlyTariff monthlyTariff -> monthlyTariff.getAmount();
      default -> 0.0;
    };
  }

  @Named("tariffToPrice")
  default Double tariffToPrice(InvoiceItemTariff tariff) {
    return switch (tariff) {
      case VolumeTariff volumeTariff -> volumeTariff.getPricePerUnit();
      case MonthlyTariff monthlyTariff -> monthlyTariff.getPricePerMonth();
      default -> 0.0;
    };
  }

}
