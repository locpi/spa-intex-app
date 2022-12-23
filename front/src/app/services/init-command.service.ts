import {environment} from "../../environments/environment";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {JacuzziPowerCommand} from "../model/JacuzziPowerCommand.model";
import {JacuzziFilterCommand} from "../model/JacuzziFilterCommand.model";
import {JacuzziHeaterCommand} from "../model/JacuzziHeaterCommand.model";
import {JacuzziBubbleCommand} from "../model/JacuzziBubbleCommand.model";
import {JacuzziTemperatureExpectedCommand} from "../model/JacuzziTemperatureExpectedCommand.model";
import {JacuzziTemperatureActualCommand} from "../model/JacuzziTemperatureActualCommand.model";
import {JacuzziWifiCommand} from "../model/JacuzziWifiCommand.model";

export class JacuzziInformation {
  tempAct!: TemperatureInformation;
  tempSet!: TemperatureInformation;
  power!: boolean;
  filter!: boolean;
  heater!: boolean;
  bubble!: boolean;
}

export class TemperatureInformation {
  value!: number;
  refreshDate!: Date;
}

class WifiInformation {
  state!: string;
  rssi!: string;
  ip!: string;
  version!: string;
}

@Injectable({
  providedIn: 'root',
})
export class InitCommandService {

  constructor(private http: HttpClient,
              private powerCommand: JacuzziPowerCommand,
              private filterCommand: JacuzziFilterCommand,
              private heater: JacuzziHeaterCommand,
              private bubble: JacuzziBubbleCommand,
              private tempExpected: JacuzziTemperatureExpectedCommand,
              private actualTemp: JacuzziTemperatureActualCommand,
              private wifi: JacuzziWifiCommand) {
  }

  initData(): void {
    this.http.get<JacuzziInformation>(environment.api.baseurl + "/api/v1/spa/information").subscribe(info => {
      this.powerCommand.power().next(info.power)
      this.filterCommand.power().next(info.filter)
      this.heater.power().next(info.heater);
      this.bubble.power().next(info.bubble);
      this.tempExpected.changeTemperature().next(info.tempSet)
      this.actualTemp.changeTemperature().next(info.tempAct)
    });

    this.http.get<WifiInformation>(environment.api.baseurl + "/api/v1/wifi/information").subscribe(info => {
      this.wifi.rssi().next(Number.parseFloat(info.rssi));
      this.wifi.ip().next(info.ip)
      this.wifi.state().next(info.state)
      this.wifi.version().next(info.version)
    });

  }


}
