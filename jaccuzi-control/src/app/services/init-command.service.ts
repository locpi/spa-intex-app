import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {PowerService} from "./power-service.service";
import {JacuzziPowerCommand} from "../tab2/model/JacuzziPowerCommand.model";
import {JacuzziFilterCommand} from "../tab2/model/JacuzziFilterCommand.model";
import {JacuzziHeaterCommand} from "../tab2/model/JacuzziHeaterCommand.model";
import {JacuzziBubbleCommand} from "../tab2/model/JacuzziBubbleCommand.model";

export class JacuzziInformation {
  tempAct!: number;
  tempSet!: number;
  power!: boolean;
  filter!: boolean;
  heater!: boolean;
  bubble!: boolean;
}

@Injectable({
  providedIn: 'root',
})
export class InitCommandService {

  constructor(private http: HttpClient,
              private powerCommand:JacuzziPowerCommand,
              private filterCommand:JacuzziFilterCommand,
              private heater:JacuzziHeaterCommand,
              private bubble:JacuzziBubbleCommand) {
  }

  initData(): void {
    this.http.get<JacuzziInformation>(environment.api.baseurl + "/api/v1/spa/information").subscribe(info => {
      this.powerCommand.power().next(info.power)
      this.filterCommand.power().next(info.filter)
      this.heater.power().next(info.heater);
      this.bubble.power().next(info.bubble);
    });

  }


}
