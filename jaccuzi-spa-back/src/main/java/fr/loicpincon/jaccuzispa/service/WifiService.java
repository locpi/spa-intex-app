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
    wifiRepository.findAll().get(0).setIp(ip);
  }

  public void setState(String message) {
    wifiRepository.findAll().get(0).setState(message);
  }

  public void setRssi(String value) {
    wifiRepository.findAll().get(0).setRssi(value);
  }

  public void setVersion(String value) {
    wifiRepository.findAll().get(0).setVersion(value);
  }
}
