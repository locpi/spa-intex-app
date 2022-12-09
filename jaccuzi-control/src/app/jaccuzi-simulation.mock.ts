import {Injectable} from "@angular/core";
import {MqttMessageService} from "./services/connector/mqtt-message-service.service";
import {environment} from "../environments/environment";
import {PowerService} from "./services/power-service.service";
import {FilterService} from "./services/filter-service.service";
import {HeaterService} from "./services/heater-service.service";
import {BubbleService} from "./services/bubble-service.service";
import {TemperatureExpectedService} from "./services/temperature-expected-service.service";
import {TemperatureActualService} from "./services/temperature-actual-service.service";

export function apiConfigProvider(config: JaccuziSimulationMock) {
  return () => config.appInits();
}

@Injectable({
  providedIn: 'root',
})
export class JaccuziSimulationMock {



  constructor(private mqttService: MqttMessageService,
              private powerService:PowerService,
              private filter:FilterService,
              private heater:HeaterService,
              private bubble:BubbleService,
              private temperatureExpectedService:TemperatureExpectedService,
              private temperatureActualService:TemperatureActualService) {
  }

  public appInits(){
    if(environment.mqtt.mock){
      console.log("config mock enabled")
      this.enablePower();
    }else{
      console.log("config mock disabled")
    }}

  private enablePower() {
    this.mqttService.observe(environment.topics.command_enable_power).subscribe(t=>{
      this.mqttService.sendMessage(environment.topics.get_power_state,t.payload.toString())
    })
  }
}

