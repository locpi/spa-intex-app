package fr.loicpincon.jaccuzispa.mqtt;

import fr.loicpincon.jaccuzispa.mqtt.config.AbstractListener;
import fr.loicpincon.jaccuzispa.service.SpaService;
import fr.loicpincon.jaccuzispa.service.TemperatureHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpaListener {

  private final IMqttClient mqttClient;

  private final SpaService service;

  private final TemperatureHistoryService temperatureHistoryService;


  @Bean
  public AbstractListener getTempAct() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "pool/water/tempAct") {
      @Override
      public void onMessage(String message) {
        temperatureHistoryService.addStats(Integer.parseInt(message));
        service.setActualTemp(Integer.parseInt(message));
      }
    };
  }

  @Bean
  public AbstractListener getTempSet() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "pool/water/tempSet") {
      @Override
      public void onMessage(String message) {
        service.setSetTemp(Integer.parseInt(message));
      }
    };
  }


  @Bean
  public AbstractListener getPower() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "pool/power") {
      @Override
      public void onMessage(String message) {
        service.setPower(message);
      }
    };
  }

  @Bean
  public AbstractListener getHeater() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "pool/heater") {
      @Override
      public void onMessage(String message) {
        service.setHeater(message);
      }
    };
  }

  @Bean
  public AbstractListener getFilter() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "pool/filter") {
      @Override
      public void onMessage(String message) {
        service.setFilter(message);
      }
    };
  }

  @Bean
  public AbstractListener getBubble() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "pool/bubble") {
      @Override
      public void onMessage(String message) {
        service.setBubble(message);
      }
    };
  }
}
