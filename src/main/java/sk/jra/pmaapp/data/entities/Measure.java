package sk.jra.pmaapp.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "measure", schema = "pma")
public class Measure {
  @Id
  @Column(name = "measure_id", nullable = false)
  private Short id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "measure_type")
  private MeasureType measureType;

  @Column(name = "serial_number", length = 30)
  private String serialNumber;

  @Column(name = "initial_value", precision = 12, scale = 3)
  private BigDecimal initialValue;

  @Column(name = "valid_from")
  private LocalDate validFrom;

  @Column(name = "valid_to")
  private LocalDate validTo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "property")
  private PropertyEntity property;

}