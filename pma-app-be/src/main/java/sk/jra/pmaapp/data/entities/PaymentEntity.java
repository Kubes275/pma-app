package sk.jra.pmaapp.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payment", schema = "pma")
public class PaymentEntity {
  @Id
  @Column(name = "payment_id", nullable = false)
  private Integer id;

  @Column(name = "p_date")
  private LocalDate pDate;

  @Column(name = "iban", length = 30)
  private String iban;

  @Column(name = "amount", precision = 6, scale = 2)
  private BigDecimal amount;

  @Column(name = "currency", length = 5)
  private String currency;

  @Column(name = "detail", length = 100)
  private String detail;

  @Column(name = "status", length = 100)
  private String status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_type", referencedColumnName = "payment_type_id")
  private PaymentType paymentType;

  @Column(name = "bank_transaction_identifier")
  private Long bankTransactionIdentifier;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contract")
  private Contract contract;

}