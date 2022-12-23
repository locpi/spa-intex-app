import {Component} from '@angular/core';
import {JacuzziWifiCommand} from "../model/JacuzziWifiCommand.model";

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {
  rssiVar!: number;

  constructor(public jacuzziWifiCommand: JacuzziWifiCommand) {
    this.jacuzziWifiCommand.rssi().subscribe(rssi => this.rssiVar = rssi)
  }

}
