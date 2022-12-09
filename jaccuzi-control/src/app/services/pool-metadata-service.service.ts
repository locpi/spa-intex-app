import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";

@Injectable({
  providedIn: 'root',
})
export class PoolMetadataService {


  constructor(private mqttService: MqttMessageService) {
  }

  getModel(): Observable<any>  {
    return this.mqttService.observe(environment.topics.get_wifi_state);
  }

  getError(): Observable<any>  {
    return this.mqttService.observe(environment.topics.get_error);
  }

}
