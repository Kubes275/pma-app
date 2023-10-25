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
@Table(name = "measure_type", schema = "pma")
public class MeasureType {
  @Id
  @Column(name = "mt_id", nullable = false)
  private Short id;

  @Column(name = "mt_name", length = 30)
  private String mtName;

  @Column(name = "mt_code", length = 10)
  private String mtCode;

}