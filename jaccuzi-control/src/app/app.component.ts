import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {JaccuziSimulationMock} from "./jaccuzi-simulation.mock";
import {j} from "chart.js/dist/chunks/helpers.core";
import {InitCommandService} from "./services/init-command.service";

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent implements OnInit{

  constructor(private init:InitCommandService) {
  }

  ngOnInit(): void {
    this.init.initData();
  }



}
