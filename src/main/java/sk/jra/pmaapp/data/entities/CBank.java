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
@Table(name = "c_bank", schema = "pma")
public class CBank {
  @Id
  @Column(name = "bank_id", nullable = false)
  private Short bankId;

  @Column(name = "b_code", length = 10)
  private String bCode;

  @Column(name = "b_name", length = 100)
  private String bName;

  @Column(name = "b_swift", length = 15)
  private String bSwift;

}