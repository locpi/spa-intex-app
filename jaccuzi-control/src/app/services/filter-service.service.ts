import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {JacuzziFilterCommand} from "../tab2/model/JacuzziFilterCommand.model";
import {AbstratCommandService} from "./AbstratCommandService";
import {JacuzziPowerCommand} from "../tab2/model/JacuzziPowerCommand.model";

@Injectable({
  providedIn: 'root',
})
export class FilterService extends AbstratCommandService{

  constructor(mqttService: MqttMessageService, http: HttpClient, defaultCommand: JacuzziFilterCommand) {
    super(mqttService, http, defaultCommand, 'filter');
  }
}
