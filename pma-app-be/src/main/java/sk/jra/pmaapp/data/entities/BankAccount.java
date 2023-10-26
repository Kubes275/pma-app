package sk.jra.pmaapp.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bank_account", schema = "pma")
public class BankAccount {
  @Id
  @Column(name = "bank_account_id", nullable = false)
  private Short id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bank", referencedColumnName = "bank_id")
  private CBank bank;

  @Column(name = "iban", nullable = false, length = 30)
  private String iban;

  @Column(name = "name", length = 50)
  private String name;

}