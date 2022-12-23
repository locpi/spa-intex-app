package fr.loicpincon.jaccuzispa.rest;

import fr.loicpincon.jaccuzispa.rest.vm.CommandBody;
import fr.loicpincon.jaccuzispa.service.SpaService;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpaCommandRestController {

  private final SpaService service;

  @PostMapping("/api/v1/spa/command")
  public void command(@RequestBody CommandBody commandBody) throws MqttException {
    service.command(commandBody.getCommand(), commandBody.getValue());
  }

}
