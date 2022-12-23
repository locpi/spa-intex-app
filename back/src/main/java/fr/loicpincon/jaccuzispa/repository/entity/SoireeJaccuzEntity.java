package fr.loicpincon.jaccuzispa.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class SoireeJaccuzEntity {

  public static final int SESSION_DURATION_HOURS = 3;

  @Id
  private String id = UUID.randomUUID().toString();

  private LocalDateTime startAt;

  private boolean finish;

  private int temperature;


}
