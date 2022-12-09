package fr.loicpincon.jaccuzispa.mqtt;

import fr.loicpincon.jaccuzispa.mqtt.config.AbstractListener;
import fr.loicpincon.jaccuzispa.service.WifiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WifiListener {

  private final IMqttClient mqttClient;

  private final WifiService wifiService;


  @Bean
  public AbstractListener wifiState() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "wifi/state") {
      @Override
      public void onMessage(String message) {
        wifiService.setState(message);
      }
    };
  }

  @Bean
  public AbstractListener wifiIp() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "wifi/ip") {
      @Override
      public void onMessage(String message) {
        wifiService.setIp(message);
      }
    };
  }

  @Bean
  public AbstractListener wifiVersion() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "wifi/version") {
      @Override
      public void onMessage(String message) {
        wifiService.setVersion(message);
      }
    };
  }

  @Bean
  public AbstractListener wifiRssi() throws MqttException, InterruptedException {
    return new AbstractListener(mqttClient, "wifi/rssi") {
      @Override
      public void onMessage(String message) {
        wifiService.setRssi(message);
      }
    };
  }
}
