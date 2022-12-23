package fr.loicpincon.jaccuzispa.rest.vm;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TemperatureHistory {

  private final LocalDateTime date;
  private final int value;


}
