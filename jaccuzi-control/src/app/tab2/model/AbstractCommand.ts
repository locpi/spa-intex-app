import {DefaultCommand} from "./DefaultCommand.model";
import {Subject} from "rxjs";


export class AbstractCommand implements DefaultCommand {

  private readonly name: string;
  private _power: Subject<boolean> = new Subject<boolean>();

  private stateActual: boolean = false

  private callable: boolean = true;

  constructor(private nameP: string) {
    this.name = nameP;
    this._power.subscribe(powerState => {
      this.stateActual = powerState
    })
  }

  public powerOn() {
    this._power.next(true);
  }

  public powerOff() {
    this.callable = true;
    this._power.next(false);
  }

  getCallable(): boolean {
    return this.callable;
  }

  getName(): string {
    return this.name;
  }

  getValue(): boolean {
    return this.stateActual;
  }

  power(): Subject<boolean> {
    return this._power;
  }

}
