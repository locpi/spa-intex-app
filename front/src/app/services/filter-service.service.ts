import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {JacuzziFilterCommand} from "../model/JacuzziFilterCommand.model";
import {AbstratCommandService} from "./AbstratCommandService";

@Injectable({
  providedIn: 'root',
})
export class FilterService extends AbstratCommandService{

  constructor(mqttService: MqttMessageService, http: HttpClient, defaultCommand: JacuzziFilterCommand) {
    super(mqttService, http, defaultCommand, 'filter');
  }
}
