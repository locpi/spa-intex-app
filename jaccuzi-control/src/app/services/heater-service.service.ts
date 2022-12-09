import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {a, an} from "chart.js/dist/chunks/helpers.core";
import {JacuzziPowerCommand} from "../tab2/model/JacuzziPowerCommand.model";
import {JacuzziHeaterCommand} from "../tab2/model/JacuzziHeaterCommand.model";
import {AbstractCommand} from "../tab2/model/AbstractCommand";
import {AbstratCommandService} from "./AbstratCommandService";

@Injectable({
  providedIn: 'root',
})
export class HeaterService extends AbstratCommandService{

  constructor(mqttService: MqttMessageService, http: HttpClient, defaultCommand: JacuzziHeaterCommand) {
    super(mqttService, http, defaultCommand, 'heater');
  }

}
