import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {JacuzziPowerCommand} from "../tab2/model/JacuzziPowerCommand.model";
import {AbstratCommandService} from "./AbstratCommandService";

@Injectable({
  providedIn: 'root',
})
export class PowerService  extends AbstratCommandService{

  constructor(mqttService: MqttMessageService, http: HttpClient, defaultCommand: JacuzziPowerCommand) {
    super(mqttService, http, defaultCommand, 'power');
  }
}
