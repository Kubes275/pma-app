package sk.jra.pmaapp.data.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sk.jra.pmaapp.data.entities.PropertyEntity;
import sk.jra.pmaapp.data.entities.PropertyType;
import sk.jra.pmaapp.data.models.CodeNameModel;
import sk.jra.pmaapp.data.models.PropertyModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertiesMapper {

  @Mapping(source = "propertyType", target = "propertyType", qualifiedByName = "propertyTypeToCodeNameModel")
  PropertyModel mapPropertyEntityToPropertyModel(PropertyEntity property);
  List<PropertyModel> mapPropertyEntityListToPropertyModelList(List<PropertyEntity> properties);

  @Named("propertyTypeToCodeNameModel")
  static CodeNameModel propertyTypeToCodeNameModel(PropertyType type) {
    return new CodeNameModel(type.getPropertyTypeId(), type.getTypeName());
  }
}
