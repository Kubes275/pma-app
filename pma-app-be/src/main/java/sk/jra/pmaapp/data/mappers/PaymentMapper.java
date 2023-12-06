package sk.jra.pmaapp.data.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.jra.pmaapp.data.entities.PaymentEntity;
import sk.jra.pmaapp.data.models.PaymentModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

  @Mapping(source = "paymentType.typeName", target = "paymentType")
  PaymentModel mapPaymentEntityToPaymentModel(PaymentEntity property);
  List<PaymentModel> mapPaymentEntityListToPaymentModelList(List<PaymentEntity> properties);

  /*@Named("propertyTypeToCodeNameModel")
  static CodeNameModel propertyTypeToCodeNameModel(PropertyType type) {
    return new CodeNameModel(type.getPropertyTypeId(), type.getTypeName());
  }*/
}
