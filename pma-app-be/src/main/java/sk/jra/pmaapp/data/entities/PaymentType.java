package sk.jra.pmaapp.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment_type", schema = "pma")
public class PaymentType {

  @Column(name = "payment_type_id", nullable = false)
  @Id
  private Short paymentTypeId;

  @Column(name = "type_name", nullable = false, length = 40)
  private String typeName;

}