import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {JacuzziHeaterCommand} from "../model/JacuzziHeaterCommand.model";
import {AbstratCommandService} from "./AbstratCommandService";

@Injectable({
  providedIn: 'root',
})
export class HeaterService extends AbstratCommandService{

  constructor(mqttService: MqttMessageService, http: HttpClient, defaultCommand: JacuzziHeaterCommand) {
    super(mqttService, http, defaultCommand, 'heater');
  }

}
