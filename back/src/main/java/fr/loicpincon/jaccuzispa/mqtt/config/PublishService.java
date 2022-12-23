package fr.loicpincon.jaccuzispa.mqtt.config;

import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublishService {

  private final IMqttClient mqttClient;

  public void send(String topic, String message) throws MqttException {
    MqttMessage mqttMessage = new MqttMessage();
    mqttMessage.setPayload(message.getBytes());
    mqttMessage.setQos(2);
    mqttMessage.setRetained(false);
    mqttClient.publish(topic, mqttMessage);
  }

}
