import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {environment} from "../../environments/environment";
import {Injectable} from "@angular/core";
import {JacuzziTemperatureActualCommand} from "../tab2/model/JacuzziTemperatureActualCommand.model";
import {TemperatureInformation} from "./init-command.service";


@Injectable({
  providedIn: 'root',
})
export class TemperatureActualService {

  constructor(private mqttService: MqttMessageService, private jacuzziTemperatureActualCommand: JacuzziTemperatureActualCommand) {
    this.mqttService.observe(environment.topics.get_actual_temperature).subscribe(data => {
      const temp = new TemperatureInformation();
      temp.refreshDate = new Date();
      temp.value = data.payload.toString() as number;
      this.jacuzziTemperatureActualCommand.changeTemperature().next(temp)
    })

  }

}
