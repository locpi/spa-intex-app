import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {AbstratCommandService} from "./AbstratCommandService";
import {JacuzziBubbleCommand} from "../model/JacuzziBubbleCommand.model";

@Injectable({
  providedIn: 'root',
})
export class BubbleService extends AbstratCommandService{


  constructor(mqttService: MqttMessageService, http: HttpClient, defaultCommand: JacuzziBubbleCommand) {
    super(mqttService, http, defaultCommand, 'bubble');
  }

}
