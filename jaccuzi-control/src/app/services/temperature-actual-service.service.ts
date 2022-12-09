import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";


@Injectable({
  providedIn: 'root',
})
export class TemperatureActualService {

  constructor(private mqttService: MqttMessageService) {
  }

  public getActualTemperature(): Observable<any> {
    return this.mqttService.observe(environment.topics.get_actual_temperature);
  }

}
