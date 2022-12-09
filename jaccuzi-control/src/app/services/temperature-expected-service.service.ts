import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {environment} from "../../environments/environment";
import {Injectable} from "@angular/core";
import {JacuzziTemperatureExpectedCommand} from "../model/JacuzziTemperatureExpectedCommand.model";
import {TemperatureInformation} from "./init-command.service";

@Injectable({
  providedIn: 'root',
})
export class TemperatureExpectedService {

  constructor(private mqttService: MqttMessageService, private jacuzziTemperatureExpectedCommand: JacuzziTemperatureExpectedCommand) {
    this.jacuzziTemperatureExpectedCommand.changeTemperature().subscribe(temp => {
      this.mqttService.sendMessage(environment.topics.command_set_expected_temp, temp.toString());
    })
    this.mqttService.observe(environment.topics.get_expected_temperature).subscribe(data => {
      const temp = new TemperatureInformation();
      temp.refreshDate = new Date();
      temp.value = data.payload.toString() as number;
      this.jacuzziTemperatureExpectedCommand.getTemperature().next(temp)
    })

  }


}
