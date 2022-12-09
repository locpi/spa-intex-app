import {environment} from "../../environments/environment";
import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {JacuzziWifiCommand} from "../model/JacuzziWifiCommand.model";

@Injectable({
  providedIn: 'root',
})
export class WifiService {


  constructor(private mqttService: MqttMessageService, private wifiCommand: JacuzziWifiCommand) {
    this.getIp()
    this.getRssi()
    this.getState()
    this.getVersion()
    this.getUpdate();
  }

  getState(): void {
    this.mqttService.observe(environment.topics.get_wifi_state).subscribe(info => {
      console.log(info.payload.toString())
      this.wifiCommand.state().next(info.payload.toString());
    })
  }

  getTemp(): void {
    this.mqttService.observe(environment.topics.get_wifi_temp).subscribe(info => {
      this.wifiCommand.temp().next(info.payload.toString());

    })
  }

  getVersion(): void {
    this.mqttService.observe(environment.topics.get_wifi_version).subscribe(info => {
      this.wifiCommand.version().next(info.payload.toString());

    })
  }

  getUpdate(): void {
    this.mqttService.observe(environment.topics.get_wifi_update).subscribe(info => {
      this.wifiCommand.update().next(info.payload.toString());

    })
  }

  getIp(): void {
    this.mqttService.observe(environment.topics.get_wifi_ip).subscribe(info => {
      this.wifiCommand.ip().next(info.payload.toString());

    })
  }

  getRssi(): void {
    this.mqttService.observe(environment.topics.get_wifi_rssi).subscribe(info => {
      this.wifiCommand.rssi().next(info.payload.toString());

    })
  }
}
