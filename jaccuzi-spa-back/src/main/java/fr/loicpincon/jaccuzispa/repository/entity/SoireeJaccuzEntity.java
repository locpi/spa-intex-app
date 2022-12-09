package fr.loicpincon.jaccuzispa.repository.entity;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SoireeJaccuzEntity {

  public static final int SESSION_DURATION_HOURS = 3;

  private int id;

  private LocalDateTime startAt;

  private boolean finish;

  private int temperature;


}
