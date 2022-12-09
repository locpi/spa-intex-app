package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
class SpaDevRepositoryImpl implements SpaRepository {

  private static JavaSpaInformationsEntity javaSpaInformationsEntity = new JavaSpaInformationsEntity();

  @PostConstruct()
  public void init(){
    javaSpaInformationsEntity.setTempAct(25);
    javaSpaInformationsEntity.setHeater(false);
    javaSpaInformationsEntity.setTempSet(40);
  }

  public JavaSpaInformationsEntity getJavaSpaInformationsEntity() {
    return javaSpaInformationsEntity;
  }

}
