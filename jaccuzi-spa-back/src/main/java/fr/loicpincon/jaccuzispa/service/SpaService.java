package fr.loicpincon.jaccuzispa.service;

import fr.loicpincon.jaccuzispa.mqtt.config.PublishService;
import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpaService {

  private final PublishService publishService;

  private final SpaRepository spaRepository;

  public JavaSpaInformationsEntity get() {
    return spaRepository.getJavaSpaInformationsEntity();
  }

  public void setActualTemp(int temp) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    javaSpaInformationsEntity.setTempAct(temp);
    spaRepository.save(javaSpaInformationsEntity);
  }

  public void setSetTemp(int parseInt) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    javaSpaInformationsEntity.setTempSet(parseInt);
    spaRepository.save(javaSpaInformationsEntity);
  }

  public void setFilter(String message) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    javaSpaInformationsEntity.setFilter(convertOnOffToBoolean(message));
    spaRepository.save(javaSpaInformationsEntity);
  }

  public void setHeater(String message) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    javaSpaInformationsEntity.setHeater(convertOnOffToBoolean(message));
    spaRepository.save(javaSpaInformationsEntity);
  }

  public void setBubble(String message) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    javaSpaInformationsEntity.setBubble(convertOnOffToBoolean(message));
    spaRepository.save(javaSpaInformationsEntity);
  }

  public void setPower(String message) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    javaSpaInformationsEntity.setPower(convertOnOffToBoolean(message));
    spaRepository.save(javaSpaInformationsEntity);
  }


  private boolean convertOnOffToBoolean(String message) {
    return "on".equals(message);
  }

  public void startHeater() throws MqttException {
    if (!get().isPower()) {
      command("power", "on");
    }
    if (!get().isFilter()) {
      command("filter", "on");
    }
    command("heater", "on");
  }

  public void command(String command, String value) throws MqttException {
    switch (command) {
      case "power":
        publishService.send("pool/command/power", value);
        break;
      case "filter":
        publishService.send("pool/command/filter", value);
        break;

      case "bubble":
        publishService.send("pool/command/bubble", value);
        break;

      case "heater":
        publishService.send("pool/command/heater", value);
        break;

    }
  }
}
