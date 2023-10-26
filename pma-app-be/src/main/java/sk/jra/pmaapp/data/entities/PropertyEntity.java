package sk.jra.pmaapp.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "property", schema = "pma")
public class PropertyEntity {
  @Id
  @Column(name = "property_id", nullable = false)
  private Short id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "property_type", referencedColumnName = "property_type_id")
  private PropertyType propertyType;

  @Column(name = "name", nullable = false, length = 16)
  private String name;

  @Column(name = "description", length = 100)
  private String description;

  @Column(name = "street", nullable = false, length = 50)
  private String street;

  @Column(name = "street_number", nullable = false)
  private Integer streetNumber;

  @Column(name = "zip", nullable = false)
  private String zip;

  @Column(name = "city", length = 50)
  private String city;

  @Column(name = "region", length = 50)
  private String region;

  @Column(name = "country", length = 50)
  private String country;

  @Column(name = "rooms_num")
  private Short roomsNum;

  @Column(name = "living_area", precision = 6, scale = 2)
  private BigDecimal livingArea;

}