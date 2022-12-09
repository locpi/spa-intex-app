package fr.loicpincon.jaccuzispa.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document()
public class JavaSpaInformationsEntity {

  @Id
  private String id = UUID.randomUUID().toString();

  private int tempAct;

  private int tempSet;

  private LocalDateTime tempSetRefreshDate;

  private LocalDateTime tempActRefreshDate;


  private int tempNightSet;

  private boolean power;

  private boolean filter;

  private boolean heater;

  private boolean bubble;


}
