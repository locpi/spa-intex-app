package fr.loicpincon.jaccuzispa.service;

import fr.loicpincon.jaccuzispa.repository.entity.WifiInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.repository.WifiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WifiService {


  private final WifiRepository wifiRepository;

  public WifiInformationsEntity get() {
    return wifiRepository.findAll().get(0);
  }

  public void setIp(String ip) {
    WifiInformationsEntity wifiInformationsEntity = get();
    wifiInformationsEntity.setIp(ip);
    wifiRepository.save(wifiInformationsEntity);
  }

  public void setState(String message) {
    WifiInformationsEntity wifiInformationsEntity = get();
    wifiInformationsEntity.setState(message);
    wifiRepository.save(wifiInformationsEntity);
  }

  public void setRssi(String value) {
    WifiInformationsEntity wifiInformationsEntity = get();
    wifiInformationsEntity.setRssi(value);
    wifiRepository.save(wifiInformationsEntity);
  }

  public void setVersion(String value) {
    WifiInformationsEntity wifiInformationsEntity = get();
    wifiInformationsEntity.setVersion(value);
    wifiRepository.save(wifiInformationsEntity);
  }
}
