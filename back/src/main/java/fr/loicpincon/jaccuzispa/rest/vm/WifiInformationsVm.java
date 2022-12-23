package fr.loicpincon.jaccuzispa.rest.vm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WifiInformationsVm {

  private String state;
  private String rssi;
  private String ip;
  private String version;

}
