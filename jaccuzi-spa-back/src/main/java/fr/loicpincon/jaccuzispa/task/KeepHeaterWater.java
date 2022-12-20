package fr.loicpincon.jaccuzispa.task;

import fr.loicpincon.jaccuzispa.PriceHeaterSpa;
import fr.loicpincon.jaccuzispa.mqtt.config.AbstractListener;
import fr.loicpincon.jaccuzispa.service.SpaService;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KeepHeaterWater {

  private final IMqttClient mqttClient;
  private final SpaService spaService;

  @PostConstruct
  public void init() throws MqttException, InterruptedException {
    new AbstractListener(mqttClient, "pool/water/tempAct") {
      @Override
      public void onMessage(String message) throws MqttException {
        int temp = Integer.parseInt(message);
        PriceHeaterSpa priceHeaterSpa = new PriceHeaterSpa();
        if (!priceHeaterSpa.isHighHour(LocalDateTime.now())) {
          if (temp < 25) {
            spaService.startHeater();
          }
          if (temp >= 30) {
            spaService.stopHeater();
          }
        }
      }
    };
  }

}
