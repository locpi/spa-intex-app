package fr.loicpincon.jaccuzispa.repository.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureHistoryEntity {

  @Id
  private String id = UUID.randomUUID().toString();

  private LocalDateTime date;

  private int value;

}
