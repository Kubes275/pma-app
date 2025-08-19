package sk.jra.pmaapp.utility.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UtilityBillInput {
  @NotNull
  private MeterStatus periodStart;
  @NotNull
  private MeterStatus periodEnd;
}
