import {Injectable} from "@angular/core";
import {Subject} from "rxjs";
import {TemperatureInformation} from "../../services/init-command.service";

@Injectable({
  providedIn: 'root',
})
export class JacuzziTemperatureExpectedCommand {

  private readonly name: string;
  private _temp: Subject<TemperatureInformation> = new Subject<TemperatureInformation>();
  private value: number = -999;
  private callable: boolean = true;
  private actualizeDate: Date = new Date();

  constructor() {
    this.name = 'Temperature cible'
    this._temp.subscribe(state => {
      this.value = state.value
      this.actualizeDate = state.refreshDate;
    })
  }

  public setExpected(value: number) {
    this.callable = true;
    const temp = new TemperatureInformation();
    temp.value = value;
    temp.refreshDate = new Date();
    this._temp.next(temp);
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
