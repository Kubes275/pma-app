package sk.jra.pmaapp.utility.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ElectricityPaymentInput {
  @NotNull
  private ElectricityState periodStart;
  @NotNull
  private ElectricityState periodEnd;
}
