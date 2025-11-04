package sk.jra.pmaapp.data.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sk.jra.pmaapp.data.entities.PropertyEntity;
import sk.jra.pmaapp.data.models.PropertyModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T12:06:40+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.9 (Homebrew)"
)
@Component
public class PropertiesMapperImpl implements PropertiesMapper {

    @Override
    public PropertyModel mapPropertyEntityToPropertyModel(PropertyEntity property) {
        if ( property == null ) {
            return null;
        }

        PropertyModel propertyModel = new PropertyModel();

        propertyModel.setPropertyType( PropertiesMapper.propertyTypeToCodeNameModel( property.getPropertyType() ) );
        if ( property.getId() != null ) {
            propertyModel.setId( property.getId().longValue() );
        }
        propertyModel.setName( property.getName() );
        propertyModel.setDescription( property.getDescription() );
        propertyModel.setStreet( property.getStreet() );
        propertyModel.setStreetNumber( property.getStreetNumber() );
        propertyModel.setZip( property.getZip() );
        propertyModel.setCity( property.getCity() );
        propertyModel.setRegion( property.getRegion() );
        propertyModel.setCountry( property.getCountry() );
        propertyModel.setRoomsNum( property.getRoomsNum() );
        propertyModel.setLivingArea( property.getLivingArea() );

        return propertyModel;
    }

    @Override
    public List<PropertyModel> mapPropertyEntityListToPropertyModelList(List<PropertyEntity> properties) {
        if ( properties == null ) {
            return null;
        }

        List<PropertyModel> list = new ArrayList<PropertyModel>( properties.size() );
        for ( PropertyEntity propertyEntity : properties ) {
            list.add( mapPropertyEntityToPropertyModel( propertyEntity ) );
        }

        return list;
    }
}
