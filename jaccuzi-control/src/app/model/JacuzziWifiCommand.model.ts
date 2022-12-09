import {Injectable} from "@angular/core";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class JacuzziWifiCommand {

  private _temp = new Subject<number>;
  private _state = new Subject<string>;
  private _update = new Subject<string>;
  private _version = new Subject<string>;
  private _ip = new Subject<string>;
  private _rssi = new Subject<number>;

  constructor() {


  }


  temp(): Subject<number> {
    return this._temp;
  }

  state(): Subject<string> {
    return this._state;
  }

  update(): Subject<string> {
    return this._update;
  }

  version(): Subject<string> {
    return this._version;
  }

  ip(): Subject<string> {
    return this._ip;
  }

  rssi(): Subject<number> {
    return this._rssi;
  }
}
