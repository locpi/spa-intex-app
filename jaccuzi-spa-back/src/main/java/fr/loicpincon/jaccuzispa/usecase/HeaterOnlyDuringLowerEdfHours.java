package fr.loicpincon.jaccuzispa.usecase;

import fr.loicpincon.jaccuzispa.HeaterDecision;
import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SoireeJaccuzRepository;
import fr.loicpincon.jaccuzispa.service.SpaService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeaterOnlyDuringLowerEdfHours {

  private final SoireeJaccuzRepository soireeJaccuzRepository;

  private final SpaService service;

  public void execute() {
    JavaSpaInformationsEntity javaSpaInformationsEntity = service.get();
    if(javaSpaInformationsEntity.isHeater()){

    }


  }
  public void start() throws MqttException {
    JavaSpaInformationsEntity javaSpaInformationsEntity = service.get();
    if(!javaSpaInformationsEntity.isHeater()){
      service.startHeater();
    }
  }

  public void stop() {
  }
}
