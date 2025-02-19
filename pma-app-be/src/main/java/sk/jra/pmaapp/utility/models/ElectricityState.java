package sk.jra.pmaapp.utility.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class ElectricityState {
  @NotNull
  @PastOrPresent
  private LocalDate date;

  @PositiveOrZero
  private double meterReadeing;
}
