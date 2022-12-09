import {DefaultCommand} from "./DefaultCommand.model";
import {Injectable} from "@angular/core";
import {TemperatureExpectedService} from "../../services/temperature-expected-service.service";
import {TemperatureActualService} from "../../services/temperature-actual-service.service";
import {D} from "chart.js/dist/chunks/helpers.core";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class JacuzziTemperatureActualCommand implements DefaultCommand {

  private readonly name: string;
  private value: number = -999;
  private callable: boolean = true;
  private actualizeDate:Date = new Date();

  constructor(private temperatureActualService: TemperatureActualService) {
    this.name = 'Temperature actuelle'
    this.temperatureActualService.getActualTemperature().subscribe(state => {
      this.value = state.payload as number;
      this.actualizeDate = new Date();
    })
  }

  powerOn(): void {
    throw new Error("Method not implemented.");
  }

  power(): Subject<boolean>{
    throw new Error("Method not implemented.");
  }


  powerOff(): void {
    throw new Error("Method not implemented.");
  }

  getCallable(): boolean {
    return this.callable;
  }

  getName(): string {
    return this.name;
  }

  getActualizeDate():Date{
    return this.actualizeDate;
  }

  getValue(): number {
    return this.value;
  }


}
