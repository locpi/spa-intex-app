import {Component, Input, OnInit} from '@angular/core';
import {DefaultCommand} from "../../tab2/model/DefaultCommand.model";

@Component({
  selector: 'app-state-command',
  templateUrl: './state-command.component.html',
  styleUrls: ['./state-command.component.scss'],
})
export class StateCommandComponent implements OnInit {

  @Input()
  command!: DefaultCommand;

  constructor() {
  }

  ngOnInit() {
  }

}
