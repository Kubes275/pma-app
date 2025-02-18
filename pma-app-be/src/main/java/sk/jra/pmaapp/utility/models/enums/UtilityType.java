package sk.jra.pmaapp.utility.models.enums;

public enum UtilityType {
  WATER("Water"),
  GAS("Gas"),
  ELECTRICITY("Electricity"),
  HEATING("Heating");

  private final String description;

  UtilityType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
