package fr.loicpincon.jaccuzispa.service;

import fr.loicpincon.jaccuzispa.mqtt.config.PublishService;
import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SpaRepository;
import java.time.LocalDateTime;
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
    javaSpaInformationsEntity.setTempActRefreshDate(LocalDateTime.now());
    spaRepository.save(javaSpaInformationsEntity);
  }

  public void setSetTemp(int parseInt) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    javaSpaInformationsEntity.setTempSet(parseInt);
    javaSpaInformationsEntity.setTempSetRefreshDate(LocalDateTime.now());
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
      managePower("on");
    }
    if (!get().isFilter()) {
      manageFilter("on");
    }
    manageHeater("on");
  }

  public void stopHeater() throws MqttException {
    if (get().isPower() && get().isHeater()) {
      manageHeater("off");
    }
  }

  public void startBubble() throws MqttException {
    if (!get().isPower()) {
      managePower("on");
    }
    manageBubble("on");
  }

  public void stopBubble() throws MqttException {
    if (get().isPower() && get().isBubble()) {
      manageBubble("off");
    }
  }

  public void startFilter() throws MqttException {
    if (!get().isPower()) {
      managePower("on");
    }
    manageFilter("on");
  }

  public void stopFilter() throws MqttException {
    if (get().isPower() && get().isFilter()) {
      manageHeater("off");
    }
  }

  public void startPower() throws MqttException {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    if (!javaSpaInformationsEntity.isPower()) {
      publishService.send("pool/command/power", "on");
    }
  }

  public void stopPower() throws MqttException {
    JavaSpaInformationsEntity javaSpaInformationsEntity = spaRepository.getJavaSpaInformationsEntity();
    if (javaSpaInformationsEntity.isPower()) {
      if (javaSpaInformationsEntity.isBubble()) {
        manageBubble("off");
      }
      if (javaSpaInformationsEntity.isHeater()) {
        manageHeater("off");
      }
      if (javaSpaInformationsEntity.isFilter()) {
        manageFilter("off");
      }
      managePower("off");
    }
  }

  private void manageHeater(String state) throws MqttException {
    publishService.send("pool/command/heater", state);
  }

  private void manageFilter(String state) throws MqttException {
    publishService.send("pool/command/filter", state);

  }

  private void managePower(String state) throws MqttException {
    publishService.send("pool/command/power", state);

  }

  private void manageBubble(String state) throws MqttException {
    publishService.send("pool/command/bubble", state);
  }

  public void command(String command, String value) throws MqttException {
    switch (command) {
      case "power":
        if (value.equals("on")) {
          startPower();
        } else {
          stopPower();
        }
        break;
      case "filter":
        if (value.equals("on")) {
          startFilter();
        } else {
          stopFilter();
        }
        break;

      case "bubble":
        if (value.equals("on")) {
          startBubble();
        } else {
          stopBubble();
        }
        break;
      case "heater":
        if (value.equals("on")) {
          startHeater();
        } else {
          stopHeater();
        }
        break;
    }
  }
}
