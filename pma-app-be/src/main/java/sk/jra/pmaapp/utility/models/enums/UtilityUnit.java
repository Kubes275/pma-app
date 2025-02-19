package sk.jra.pmaapp.utility.models.enums;

public enum UtilityUnit {
  KWH("Kilowatt-hour"),
  M3("Cubic meter");

  private final String description;

  UtilityUnit(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
