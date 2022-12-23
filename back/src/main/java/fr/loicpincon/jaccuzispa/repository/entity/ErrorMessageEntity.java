package fr.loicpincon.jaccuzispa.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class ErrorMessageEntity {

  @Id
  private String id = UUID.randomUUID().toString();

  private LocalDateTime time;
  private String message;
  private boolean see;


}
