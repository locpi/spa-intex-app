import {Component, OnInit} from '@angular/core';

import {JacuzziFilterCommand} from "./model/JacuzziFilterCommand.model";
import {JacuzziPowerCommand} from "./model/JacuzziPowerCommand.model";
import {JacuzziBubbleCommand} from "./model/JacuzziBubbleCommand.model";
import {JacuzziHeaterCommand} from "./model/JacuzziHeaterCommand.model";

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page implements OnInit {




  constructor(public jacuzziFilterCommand: JacuzziFilterCommand,
              public jacuzziPowerCommand: JacuzziPowerCommand,
              public jacuzziBubbleCommand: JacuzziBubbleCommand,
              public jacuzziHeaterCommand: JacuzziHeaterCommand) {
  }

  ngOnInit(): void {


  }


}
