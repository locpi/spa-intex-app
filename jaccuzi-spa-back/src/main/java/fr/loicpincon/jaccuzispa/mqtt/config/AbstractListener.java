package fr.loicpincon.jaccuzispa.mqtt.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

@Slf4j
public abstract class AbstractListener {

  private final IMqttClient mqttClient;

  private final String topic;


  public AbstractListener(IMqttClient mqttClient, String topic) throws MqttException, InterruptedException {
    this.mqttClient = mqttClient;
    this.topic = topic;
    init();
  }

  public abstract void onMessage(String message);


  public void init() throws MqttException, InterruptedException {
    subscribe(topic);
  }

  public void subscribe(final String topic) throws MqttException, InterruptedException {
    mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
      String s = new String(msg.getPayload());
      log.debug("Message entrant {} sur {}", topic, s);
      onMessage(s);
    });
  }
}
