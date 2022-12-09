import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Chart, registerables} from "chart.js";
import {JacuzziFilterCommand} from "../tab2/model/JacuzziFilterCommand.model";
import {JacuzziPowerCommand} from "../tab2/model/JacuzziPowerCommand.model";
import {JacuzziBubbleCommand} from "../tab2/model/JacuzziBubbleCommand.model";
import {JacuzziHeaterCommand} from "../tab2/model/JacuzziHeaterCommand.model";
import {JacuzziTemperatureExpectedCommand} from "../tab2/model/JacuzziTemperatureExpectedCommand.model";
import {JacuzziTemperatureActualCommand} from "../tab2/model/JacuzziTemperatureActualCommand.model";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";


export class TemperatureHistory {
  date!: Date;
  value!: number;
}

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
              public jacuzziTemperatureExpectedCommand: JacuzziTemperatureExpectedCommand,
              public jacuzziTemperatureActualCommand: JacuzziTemperatureActualCommand,
              private http: HttpClient) {
  }

  ngOnInit(): void {
    Chart.register(...registerables)

  }


  ngAfterViewInit() {
    this.http.get<TemperatureHistory[]>(environment.api.baseurl + '/api/v1/spa/information/temperature/stats').subscribe(data => {
      this.doubleLineChartMethod(data);
    })
  }


  doubleLineChartMethod(data: TemperatureHistory[]) {
    const labels = data.map(f => {
      const d = new Date(f.date);
      return d.getDay() + "/" + d.getMonth() + " " + d.getHours() + ":" + d.getMinutes();
    })

    this.doubleLineChart = new Chart(this.doubleLineCanvas.nativeElement, {
      type: 'line',
      data: {
        labels: labels,
        datasets: [{
          label: 'Suivi de temperature',
          data: data.map(f => f.value),
          fill: false,
          borderColor: 'rgb(75, 192, 192)',
          tension: 0.1
        }]

      }
    })
  }


}

function onlyUnique(value: TemperatureHistory, index: any, self: any) {
  return self.indexOf(value) === index;
}
