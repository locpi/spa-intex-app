import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-temparature-card',
  templateUrl: './temparature-card.component.html',
  styleUrls: ['./temparature-card.component.scss'],
})
export class TemparatureCardComponent implements OnInit {

  @Input()
  public temperatureLastDate!:Date;

  @Input()
  public temperature!:number;

  @Input()
  public label!:String;

  @Input()
  public dateLabel!:String;

  constructor() { }

  ngOnInit() {}

}
