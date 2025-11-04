package sk.jra.pmaapp.data.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sk.jra.pmaapp.data.entities.PaymentEntity;
import sk.jra.pmaapp.data.entities.PaymentType;
import sk.jra.pmaapp.data.models.PaymentModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T12:06:40+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.9 (Homebrew)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentModel mapPaymentEntityToPaymentModel(PaymentEntity property) {
        if ( property == null ) {
            return null;
        }

        PaymentModel paymentModel = new PaymentModel();

        paymentModel.setPaymentType( propertyPaymentTypeTypeName( property ) );
        if ( property.getId() != null ) {
            paymentModel.setId( property.getId().longValue() );
        }
        paymentModel.setPDate( property.getPDate() );
        paymentModel.setIban( property.getIban() );
        paymentModel.setAmount( property.getAmount() );
        paymentModel.setCurrency( property.getCurrency() );
        paymentModel.setDetail( property.getDetail() );
        paymentModel.setStatus( property.getStatus() );

        return paymentModel;
    }

    @Override
    public List<PaymentModel> mapPaymentEntityListToPaymentModelList(List<PaymentEntity> properties) {
        if ( properties == null ) {
            return null;
        }

        List<PaymentModel> list = new ArrayList<PaymentModel>( properties.size() );
        for ( PaymentEntity paymentEntity : properties ) {
            list.add( mapPaymentEntityToPaymentModel( paymentEntity ) );
        }

        return list;
    }

    private String propertyPaymentTypeTypeName(PaymentEntity paymentEntity) {
        if ( paymentEntity == null ) {
            return null;
        }
        PaymentType paymentType = paymentEntity.getPaymentType();
        if ( paymentType == null ) {
            return null;
        }
        String typeName = paymentType.getTypeName();
        if ( typeName == null ) {
            return null;
        }
        return typeName;
    }
}
