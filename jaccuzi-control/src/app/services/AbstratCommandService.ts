import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Inject, Injectable} from "@angular/core";
import {AbstractCommand} from "../model/AbstractCommand";


@Injectable({
  providedIn: 'root',
})
export class AbstratCommandService {

  private commandName: string;

  constructor(private mqttService: MqttMessageService,
              private http: HttpClient,
              private defaultCommand: AbstractCommand,
              @Inject(String) commandNameP: string) {
    this.commandName = commandNameP;
    this.defaultCommand.power().subscribe(value => {
        if (value) {
          this.powerOn();
        } else {
          this.powerOff()
        }
    })
  }


  private powerOn(): void {
    this.http.post(environment.api.baseurl + "/api/v1/spa/command", {command: this.commandName, value: 'on'}).subscribe();
  }

  private powerOff(): void {
    this.http.post(environment.api.baseurl + "/api/v1/spa/command", {command: this.commandName, value: 'off'}).subscribe();
  }

  powerState(): void {
    this.mqttService.observe(environment.topics.get_power_state).subscribe(data => {
      let powerOn = data.payload.toString() == 'on';
      this.defaultCommand.power().next(powerOn);
    });
  }


}
