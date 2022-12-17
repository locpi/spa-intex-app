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
public class StartHeaterAutamitecly {

  private final SoireeJaccuzRepository soireeJaccuzRepository;

  private final SpaService service;

  public void execute() {
    JavaSpaInformationsEntity javaSpaInformationsEntity = service.get();
    soireeJaccuzRepository.findAllByFinish(false).forEach(soiree -> {
      if (LocalDateTime.now().isAfter(soiree.getStartAt())) {
        soiree.setFinish(true);
        soireeJaccuzRepository.save(soiree);
      } else {
        HeaterDecision build = HeaterDecision.builder()
                                             .actualTime(LocalDateTime.now())
                                             .forTime(soiree.getStartAt())
                                             .tempAct(javaSpaInformationsEntity.getTempAct())
                                             .tempSet(soiree.getTemperature())
                                             .build();

        if (build.startHeater()) {
          if (build.diffTemperatureForTime() > 3) {
            throw new RuntimeException("La temperature sera differente de plus de 3 degres, soirée annulé");
          }
          try {
            if (!service.get().isHeater()) {
              service.startHeater();
            }
          } catch (MqttException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });

  }


}
