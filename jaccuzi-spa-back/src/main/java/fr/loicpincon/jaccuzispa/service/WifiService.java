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
    return wifiRepository.getJavaSpaInformationsEntity();
  }

  public void setIp(String ip) {
    wifiRepository.getJavaSpaInformationsEntity().setIp(ip);
  }

  public void setState(String message) {
    wifiRepository.getJavaSpaInformationsEntity().setState(message);
  }

  public void setRssi(String value) {
    wifiRepository.getJavaSpaInformationsEntity().setRssi(value);
  }

  public void setVersion(String value) {
    wifiRepository.getJavaSpaInformationsEntity().setVersion(value);
  }
}
