package sk.jra.pmaapp.utility.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sk.jra.pmaapp.utility.models.InvoiceItem;
import sk.jra.pmaapp.utility.models.InvoiceItemModel;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T12:06:40+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.9 (Homebrew)"
)
@Component
public class ElectricityInvoiceMapperImpl implements ElectricityInvoiceMapper {

    @Override
    public InvoiceItemModel mapInvoiceItemToInvoiceItemModel(InvoiceItem item) {
        if ( item == null ) {
            return null;
        }

        double total = 0.0d;
        double amount = 0.0d;
        double unitPrice = 0.0d;
        String name = null;
        String unit = null;

        total = tariffToTotalPrice( item.getTariff() );
        amount = tariffToAmount( item.getTariff() );
        unitPrice = tariffToPrice( item.getTariff() );
        name = item.getName();
        if ( item.getUnit() != null ) {
            unit = item.getUnit().name();
        }

        InvoiceItemModel invoiceItemModel = new InvoiceItemModel( name, unit, unitPrice, amount, total );

        return invoiceItemModel;
    }

    @Override
    public List<InvoiceItemModel> mapInvoiceItemListToInvoiceItemModelList(List<InvoiceItem> properties) {
        if ( properties == null ) {
            return null;
        }

        List<InvoiceItemModel> list = new ArrayList<InvoiceItemModel>( properties.size() );
        for ( InvoiceItem invoiceItem : properties ) {
            list.add( mapInvoiceItemToInvoiceItemModel( invoiceItem ) );
        }

        return list;
    }
}
