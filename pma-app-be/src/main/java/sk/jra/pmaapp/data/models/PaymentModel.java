package sk.jra.pmaapp.data.models;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentModel {

  private Long id;
  private LocalDate pDate;
  private String iban;
  private BigDecimal amount;
  private String currency;
  private String detail;
  private String status;
  private String paymentType;
  private Long transactionId;
  private Long contractId;
}