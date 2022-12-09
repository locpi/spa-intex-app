package fr.loicpincon.jaccuzispa;

import static java.time.temporal.ChronoUnit.HOURS;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Builder;

@Builder
public class HeaterDecision {

  private static final int HEATER_PER_HOUR = 2;

  private final LocalDateTime forTime;

  private final LocalDateTime actualTime;

  private final int tempAct;

  private final int tempSet;

  public boolean startHeater() {
    final int diffTemp = Math.abs(tempAct - tempSet);
    int numberHour = diffTemp / HEATER_PER_HOUR;
    LocalDateTime dateWhenIsHot = actualTime.plus(numberHour, HOURS);
    long between = ChronoUnit.MINUTES.between(dateWhenIsHot, forTime);
    return between <= 15;
  }

  public long finalTemperatureForTime() {
    long between = Math.abs(HOURS.between(forTime, actualTime));
    return tempAct + HEATER_PER_HOUR * between;
  }

  public int diffTemperatureForTime() {
    return Math.toIntExact(tempSet - finalTemperatureForTime());
  }

}
