import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";

@Injectable({
  providedIn: 'root',
})
export class WifiService {


  constructor(private mqttService: MqttMessageService) {
  }

  getState(): Observable<any>  {
    return this.mqttService.observe(environment.topics.get_wifi_state);
  }

  getTemp(): Observable<any>  {
    return this.mqttService.observe(environment.topics.get_wifi_temp);
  }

  getVersion(): Observable<any> {
    return this.mqttService.observe(environment.topics.get_wifi_version);
  }

  getUpdate(): Observable<any> {
    return this.mqttService.observe(environment.topics.get_wifi_update);
  }

  getIp(): Observable<any> {
    return this.mqttService.observe(environment.topics.get_wifi_ip);
  }

  getRssi() : Observable<any>{
    return this.mqttService.observe(environment.topics.get_wifi_rssi);
  }
}
