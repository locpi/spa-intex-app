import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {JacuzziPowerCommand} from "../tab2/model/JacuzziPowerCommand.model";
import {AbstratCommandService} from "./AbstratCommandService";
import {JacuzziBubbleCommand} from "../tab2/model/JacuzziBubbleCommand.model";

@Injectable({
  providedIn: 'root',
})
export class BubbleService extends AbstratCommandService{


  constructor(mqttService: MqttMessageService, http: HttpClient, defaultCommand: JacuzziBubbleCommand) {
    super(mqttService, http, defaultCommand, 'bubble');
  }

}
