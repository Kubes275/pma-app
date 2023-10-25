package sk.jra.pmaapp.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contract", schema = "pma")
public class Contract {
  @Id
  @Column(name = "contract_id", nullable = false)
  private Short id;

  @Column(name = "date_from", nullable = false)
  private LocalDate dateFrom;

  @Column(name = "date_to")
  private LocalDate dateTo;

  @Column(name = "rent_price", precision = 6, scale = 2)
  private BigDecimal rentPrice;

  @Column(name = "rent_services", precision = 6, scale = 2)
  private BigDecimal rentServices;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "property")
  private PropertyEntity property;

}