import {Injectable} from "@angular/core";
import {WifiService} from "../services/wifi-service.service";

@Injectable({
  providedIn: 'root',
})
export class JacuzziWifiCommand {

  private _temp: number = -999;
  private _state: string = '';
  private _update: string = '';
  private _version: string = '';
  private _ip: string = '';
  private _rssi: number = 0;

  constructor(private wifiService: WifiService) {

    this.wifiService.getUpdate().subscribe(state => {
      this._update = state.payload.toString();
    })

    this.wifiService.getTemp().subscribe(state => {
      this._temp = state.payload.toString();
    })
    this.wifiService.getVersion().subscribe(state => {
      this._version = state.payload.toString();
    })
    this.wifiService.getState().subscribe(state => {
      this._state = state.payload.toString();
    })
    this.wifiService.getIp().subscribe(ip => {
      this._ip = ip.payload.toString();
    })
    this.wifiService.getRssi().subscribe(rssi => {
      console.log(rssi.payload.toString())
      this._rssi = rssi.payload.toString();
    })
  }


  get temp(): number {
    return this._temp;
  }

  get state(): string {
    return this._state;
  }

  get update(): string {
    return this._update;
  }

  get version(): string {
    return this._version;
  }


  get ip(): string {
    return this._ip;
  }


  get rssi(): number {
    return this._rssi;
  }
}
