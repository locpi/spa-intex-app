package fr.loicpincon.jaccuzispa.repository.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WifiInformationsEntity {

  private String state;
  private String rssi;
  private String ip;
  private String version;

}
