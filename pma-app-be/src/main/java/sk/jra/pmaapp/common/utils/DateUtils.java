package sk.jra.pmaapp.common.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class DateUtils {

  public double getMonthsBetweenDates(LocalDate startDate, LocalDate endDate) {
    Period period = Period.between(startDate, endDate);
    int totalMonths = period.getYears() * 12 + period.getMonths();

    int daysInStartMonth = startDate.lengthOfMonth();
    int daysInEndMonth = endDate.lengthOfMonth();

    double partialStartMonth = (double) (daysInStartMonth - startDate.getDayOfMonth() + 1) / daysInStartMonth;
    double partialEndMonth = (double) endDate.getDayOfMonth() / daysInEndMonth;

    return totalMonths + partialStartMonth + partialEndMonth - 1; // Subtract 1 to avoid double-counting the start month
  }
}
