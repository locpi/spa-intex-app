import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root',
})
export class TemperatureExpectedService {

  constructor(private mqttService: MqttMessageService) {
  }

  public setExpected(value: number): void {
    this.mqttService.sendMessage(environment.topics.command_set_expected_temp, value.toString());
  }

  public getExpectedTemperature(): Observable<any> {
    return this.mqttService.observe(environment.topics.get_expected_temperature);
  }

}
