import { Component } from '@angular/core';
import {JacuzziWifiCommand} from "../tab2/model/JacuzziWifiCommand.model";

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {

  constructor(public jacuzziWifiCommand:JacuzziWifiCommand) {}

}
