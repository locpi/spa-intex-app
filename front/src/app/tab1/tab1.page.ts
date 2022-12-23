import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Chart, registerables} from "chart.js";
import {JacuzziFilterCommand} from "../model/JacuzziFilterCommand.model";
import {JacuzziPowerCommand} from "../model/JacuzziPowerCommand.model";
import {JacuzziBubbleCommand} from "../model/JacuzziBubbleCommand.model";
import {JacuzziHeaterCommand} from "../model/JacuzziHeaterCommand.model";
import {JacuzziTemperatureExpectedCommand} from "../model/JacuzziTemperatureExpectedCommand.model";
import {JacuzziTemperatureActualCommand} from "../model/JacuzziTemperatureActualCommand.model";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {ErrorService, JacuzziError} from "../services/error.service";


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

  public jacError?: JacuzziError;

  constructor(public jacuzziFilterCommand: JacuzziFilterCommand,
              public jacuzziPowerCommand: JacuzziPowerCommand,
              public jacuzziBubbleCommand: JacuzziBubbleCommand,
              public jacuzziHeaterCommand: JacuzziHeaterCommand,
              public jacuzziTemperatureExpectedCommand: JacuzziTemperatureExpectedCommand,
              public jacuzziTemperatureActualCommand: JacuzziTemperatureActualCommand,
              private http: HttpClient,
              private errorService: ErrorService) {
  }

  ngOnInit(): void {
    Chart.register(...registerables)
    this.errorService.getError().subscribe(j => this.jacError = j);
  }


  ngAfterViewInit() {
    this.http.get<TemperatureHistory[]>(environment.api.baseurl + '/api/v1/spa/information/temperature/stats').subscribe(data => {
      this.doubleLineChartMethod(data);
    })
  }


  doubleLineChartMethod(data: TemperatureHistory[]) {
    const labels = data.map(f => {
      const d = new Date(f.date);
      return d.getDay() + "/" + d.getMonth() + " " + this.getHoursFormat(d);
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


  private getHoursFormat(d: Date) {
    let hours = ''
    let minutes = ''
    if (d.getHours() < 10) {
      hours = '0';
    }
    if (d.getMinutes() < 10) {
      minutes = '0';
    }
    return hours + d.getHours() + ":" + minutes + d.getMinutes();
  }

  deleteError() {
    this.errorService.deleteError();
    this.jacError = undefined;
  }
}

