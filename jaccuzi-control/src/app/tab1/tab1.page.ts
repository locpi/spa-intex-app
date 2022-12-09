import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Chart, registerables} from "chart.js";
import {JacuzziFilterCommand} from "../tab2/model/JacuzziFilterCommand.model";
import {JacuzziPowerCommand} from "../tab2/model/JacuzziPowerCommand.model";
import {JacuzziBubbleCommand} from "../tab2/model/JacuzziBubbleCommand.model";
import {JacuzziHeaterCommand} from "../tab2/model/JacuzziHeaterCommand.model";
import {JacuzziTemperatureExpectedCommand} from "../tab2/model/JacuzziTemperatureExpectedCommand.model";
import {JacuzziTemperatureActualCommand} from "../tab2/model/JacuzziTemperatureActualCommand.model";


@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit {

  @ViewChild('doubleLineCanvas') doubleLineCanvas!: ElementRef;

  doubleLineChart: any;

  constructor(public jacuzziFilterCommand: JacuzziFilterCommand,
              public jacuzziPowerCommand: JacuzziPowerCommand,
              public jacuzziBubbleCommand: JacuzziBubbleCommand,
              public jacuzziHeaterCommand: JacuzziHeaterCommand,
              public jacuzziTemperatureExpectedCommand:JacuzziTemperatureExpectedCommand,
              public jacuzziTemperatureActualCommand:JacuzziTemperatureActualCommand) {
  }

  ngOnInit(): void {
    Chart.register(...registerables)

  }


  ngAfterViewInit() {
    this.doubleLineChartMethod();
  }

  doubleLineChartMethod() {
    const labels = ['1', '2', '3']

    this.doubleLineChart = new Chart(this.doubleLineCanvas.nativeElement, {
      type: 'line',
      data: {
        labels: labels,
        datasets: [{
          label: 'My First Dataset',
          data: [65, 59, 80, 81, 56, 55, 40],
          fill: false,
          borderColor: 'rgb(75, 192, 192)',
          tension: 0.1
        }]

      }
    })
  }


}
