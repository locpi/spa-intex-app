import {Component, Input, OnInit} from '@angular/core';
import {DefaultCommand} from "../model/DefaultCommand.model";

@Component({
  selector: 'app-command-list-item',
  templateUrl: './command-list-item.component.html',
  styleUrls: ['./command-list-item.component.scss'],
})
export class CommandListItemComponent implements OnInit {

  @Input()
  public command!: DefaultCommand;

  public state: boolean = false;

  constructor() {
  }

  ngOnInit() {
    this.state = this.command.getValue();
  }

  changeStatus($event: boolean) {
    console.log($event)
    console.log(this.command.getValue())
    if(this.command.getValue()!=$event){
      if ($event) {
        this.command.powerOn();
      } else {
        this.command.powerOff();
      }
    }

  }
}
