package sk.jra.pmaapp.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "deduction_consumption", schema = "pma")
public class DeductionConsumption {
  @Id
  @Column(name = "dc_id", nullable = false)
  private Short id;

  @Column(name = "dc_date")
  private LocalDate dcDate;

  @Column(name = "dc_value", precision = 12, scale = 3)
  private BigDecimal dcValue;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "property")
  private PropertyEntity property;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "measure")
  private Measure measure;

}