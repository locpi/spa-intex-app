package fr.loicpincon.jaccuzispa.repository;

import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.entity.WifiInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SpaRepository;
import fr.loicpincon.jaccuzispa.repository.repository.WifiRepository;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitSpa {


  private final SpaRepository spaRepository;
  private final WifiRepository wifiRepository;
  @PostConstruct
  public void init() {
    if (spaRepository.findAll().isEmpty()) {
      JavaSpaInformationsEntity entity = new JavaSpaInformationsEntity();
      spaRepository.save(entity);
    }
    if (wifiRepository.findAll().isEmpty()) {
      WifiInformationsEntity entity = new WifiInformationsEntity();
      wifiRepository.save(entity);
    }

  }

}
