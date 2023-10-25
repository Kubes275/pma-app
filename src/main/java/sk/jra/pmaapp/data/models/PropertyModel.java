package sk.jra.pmaapp.data.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyModel {

  private Long id;
  private CodeNameModel propertyType;
  private String name;
  private String description;
  private String street;
  private Integer streetNumber;
  private Integer zip;
  private String city;
  private String region;
  private String country;
  private Short roomsNum;
  private BigDecimal livingArea;

}