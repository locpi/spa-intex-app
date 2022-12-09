import {Component, Input, OnInit} from '@angular/core';
import {DefaultCommand} from "../../model/DefaultCommand.model";
import {AlertController} from "@ionic/angular";

@Component({
  selector: 'app-state-command',
  templateUrl: './state-command.component.html',
  styleUrls: ['./state-command.component.scss'],
})
export class StateCommandComponent implements OnInit {

  @Input()
  command!: DefaultCommand;

  constructor(private alertController: AlertController) {
  }

  ngOnInit() {
  }

  async event() {
    const confirmation = await this.warn();
    if (confirmation) {
      if (this.command.getValue()) {
        this.command.powerOff()
      } else {
        this.command.powerOn()
      }
    }
  }

  private stringState() {
    if (this.command.getValue()) {
      return "eteindre"
    } else {
      return "allumer"
    }
  }

  async warn() {
    return new Promise(async (resolve) => {
      const confirm = await this.alertController.create({
        header: 'Attention',
        message: 'Voulez vous ' + this.stringState() + ' le ' + this.command.getName() + ' ?',
        buttons: [
          {
            text: 'Non',
            role: 'cancel',
            handler: () => {
              return resolve(false);
            },
          },
          {
            text: 'Oui',
            handler: () => {
              return resolve(true);
            },
          },
        ],
      });

      await confirm.present();
    });
  }
}
