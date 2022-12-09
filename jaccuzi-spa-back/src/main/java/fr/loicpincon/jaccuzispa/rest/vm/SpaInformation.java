package fr.loicpincon.jaccuzispa.rest.vm;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpaInformation {

  private TemperatureInformation tempAct;

  private TemperatureInformation tempSet;

  private boolean power;

  private boolean filter;

  private boolean heater;

  private boolean bubble;


  @Getter
  @Builder
  public static class TemperatureInformation {

    private final int value;
    private final LocalDateTime refreshDate;
  }
}
