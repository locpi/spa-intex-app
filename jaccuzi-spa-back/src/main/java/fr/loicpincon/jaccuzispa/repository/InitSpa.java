package fr.loicpincon.jaccuzispa.repository;

import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SpaRepository;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitSpa {


  private final SpaRepository spaRepository;

  @PostConstruct
  public void init() {
    if (spaRepository.findAll().isEmpty()) {
      JavaSpaInformationsEntity entity = new JavaSpaInformationsEntity();
      spaRepository.save(entity);
    }

  }

}
