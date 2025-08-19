package sk.jra.pmaapp.utility.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sk.jra.pmaapp.utility.models.enums.UtilityType;
import sk.jra.pmaapp.utility.models.enums.UtilityUnit;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class MeterStatus {
  @NotNull
  @PastOrPresent
  private LocalDate date;

  @PositiveOrZero
  private double meterReadeing;

  //TODO: load types and units from database
  @NotNull
  private UtilityType meterType;
  @NotNull
  private UtilityUnit meterUnits;
}
