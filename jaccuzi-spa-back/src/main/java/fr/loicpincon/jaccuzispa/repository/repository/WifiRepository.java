package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.WifiInformationsEntity;
import org.springframework.stereotype.Component;

@Component
public class WifiRepository {

  private static WifiInformationsEntity wifiInformationsEntity = new WifiInformationsEntity();


  public WifiInformationsEntity getJavaSpaInformationsEntity() {
    return wifiInformationsEntity;
  }

}
