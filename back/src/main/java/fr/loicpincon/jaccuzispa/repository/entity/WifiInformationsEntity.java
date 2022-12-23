package fr.loicpincon.jaccuzispa.repository.entity;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class WifiInformationsEntity {

  @Id
  private String id = UUID.randomUUID().toString();

  private String state;
  private String rssi;
  private String ip;
  private String version;

}
