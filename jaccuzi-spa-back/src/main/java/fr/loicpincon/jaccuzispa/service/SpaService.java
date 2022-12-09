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
    spaRepository.getJavaSpaInformationsEntity().setTempAct(temp);
  }

  public void setSetTemp(int parseInt) {
    spaRepository.getJavaSpaInformationsEntity().setTempSet(parseInt);
  }

  public void setFilter(String message) {
    spaRepository.getJavaSpaInformationsEntity().setFilter(convertOnOffToBoolean(message));
  }

  public void setHeater(String message) {
    spaRepository.getJavaSpaInformationsEntity().setHeater(convertOnOffToBoolean(message));
  }

  public void setBubble(String message) {
    spaRepository.getJavaSpaInformationsEntity().setBubble(convertOnOffToBoolean(message));
  }

  public void setPower(String message) {
    spaRepository.getJavaSpaInformationsEntity().setPower(convertOnOffToBoolean(message));
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
      case "power" -> publishService.send("pool/command/power", value);
      case "filter" -> publishService.send("pool/command/filter", value);
      case "bubble" -> publishService.send("pool/command/bubble", value);
      case "heater" -> publishService.send("pool/command/heater", value);
    }
  }
}
