import {Component, OnInit} from '@angular/core';
import {ModalController} from "@ionic/angular";
import {AddComponent} from "../add/add.component";
import {HttpClient} from "@angular/common/http";
import {PartyVm} from "../vm/party.vm";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  private message!: string;

  partys: PartyVm[] = []

  constructor(private modalCtrl: ModalController, private http: HttpClient) {
  }

  ngOnInit() {
    this.getParyts()
  }


  private getParyts(){
    this.http.get<PartyVm[]>(environment.api.baseurl+"/api/v1/party").subscribe(data=> this.partys = data)
  }

  async openModal() {
    const modal = await this.modalCtrl.create({
      component: AddComponent,
    });
    modal.present();

    const {data, role} = await modal.onWillDismiss();

    if (role === 'confirm') {
      this.message = `Hello, ${data}!`;
    }
    this.getParyts()

  }
}
