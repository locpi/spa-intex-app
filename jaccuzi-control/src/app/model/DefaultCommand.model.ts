import {Subject} from "rxjs";


export interface DefaultCommand {

  getName():string;
  getCallable():boolean;
  powerOn():void;
  powerOff():void
  getValue():any
  power(): Subject<boolean> ;
}
