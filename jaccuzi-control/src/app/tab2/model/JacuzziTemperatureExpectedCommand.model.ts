import {DefaultCommand} from "./DefaultCommand.model";
import {Injectable} from "@angular/core";
import {TemperatureExpectedService} from "../../services/temperature-expected-service.service";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class JacuzziTemperatureExpectedCommand implements DefaultCommand {

  private readonly name: string;
  private value: number = -999;
  private callable: boolean = true;
  private actualizeDate: Date = new Date();

  constructor(private temperatureExpectedService: TemperatureExpectedService) {
    this.name = 'Temperature cible'
    this.temperatureExpectedService.getExpectedTemperature().subscribe(state => {
      console.log(state.payload.toString())
      this.value = state.payload as number;
    })
  }
  power(): Subject<boolean>{
    throw new Error("Method not implemented.");
  }
  powerOn(): void {
    throw new Error("Method not implemented.");
  }

  powerOff(): void {
    throw new Error("Method not implemented.");
  }

  public setExpected(value: number) {
    this.value = value;
    this.callable = true;
    this.actualizeDate = new Date();
    this.temperatureExpectedService.setExpected(value);
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

  getActualizeDate():Date{
    return this.actualizeDate;
  }
}
