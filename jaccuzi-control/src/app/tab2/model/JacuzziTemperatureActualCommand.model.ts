import {Injectable} from "@angular/core";
import {Subject} from "rxjs";
import {TemperatureInformation} from "../../services/init-command.service";

@Injectable({
  providedIn: 'root',
})
export class JacuzziTemperatureActualCommand {
  private readonly name: string;
  private _temp: Subject<TemperatureInformation> = new Subject<TemperatureInformation>();
  private value: number = -999;
  private callable: boolean = true;
  private actualizeDate: Date = new Date();

  constructor() {
    this.name = 'Temperature actuelle'
    this._temp.subscribe(state => {
      this.value = state.value;
      this.actualizeDate = state.refreshDate;
    })
  }

  getCallable(): boolean {
    return this.callable;
  }

  getName(): string {
    return this.name;
  }

  getValue(): number {
    return this.value;
  }

  getActualizeDate(): Date {
    return this.actualizeDate;
  }

  changeTemperature(): Subject<TemperatureInformation> {
    return this._temp;
  }
}
