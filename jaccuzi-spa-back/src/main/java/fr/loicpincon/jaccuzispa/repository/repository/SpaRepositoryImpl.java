package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
 class SpaRepositoryImpl implements SpaRepository {

  private static JavaSpaInformationsEntity javaSpaInformationsEntity = new JavaSpaInformationsEntity();


  public JavaSpaInformationsEntity getJavaSpaInformationsEntity() {
    return javaSpaInformationsEntity;
  }

}
