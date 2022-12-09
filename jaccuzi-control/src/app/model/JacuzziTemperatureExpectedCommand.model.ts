import {Injectable} from "@angular/core";
import {Subject} from "rxjs";
import {TemperatureInformation} from "../services/init-command.service";

@Injectable({
  providedIn: 'root',
})
export class JacuzziTemperatureExpectedCommand {

  private readonly name: string;
  private tempSet: Subject<TemperatureInformation> = new Subject<TemperatureInformation>();
  private tempGet: Subject<TemperatureInformation> = new Subject<TemperatureInformation>();
  private value: number = -999;
  private callable: boolean = true;
  private actualizeDate: Date = new Date();

  constructor() {
    this.name = 'Temperature cible'
    this.tempGet.subscribe(state => {
      this.value = state.value
      this.actualizeDate = state.refreshDate;
    })
  }

  public setExpected(value: number) {
    this.callable = true;
    const temp = new TemperatureInformation();
    temp.value = value;
    temp.refreshDate = new Date();
    this.tempSet.next(temp);
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
    return this.tempSet;
  }

  getTemperature(): Subject<TemperatureInformation> {
    return this.tempGet;
  }
}
