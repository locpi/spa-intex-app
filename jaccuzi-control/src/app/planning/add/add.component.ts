import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { ModalController } from '@ionic/angular';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss'],
})
export class AddComponent implements OnInit {
  profileForm = new FormGroup({
    date: new FormControl('', Validators.required),
    temp: new FormControl('', Validators.compose(
      [Validators.required,Validators.min(20),Validators.max(40)])),
  });
  visible: boolean = true;
  @ViewChild('modal') doubleLineCanvas!: ElementRef;

  constructor(private modalCtrl: ModalController,private http:HttpClient) {}

  ngOnInit() {
  }


  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.profileForm.value);
this.confirm();
  }

  cancel() {
    return this.modalCtrl.dismiss(null, 'cancel');

  }

  confirm() {
    this.http.post(environment.api.baseurl+'/api/v1/party',{
      startAt:this.profileForm.controls.date.value,
      temp:this.profileForm.controls.temp.value
    }).subscribe(ok=>{
      return this.modalCtrl.dismiss(this.profileForm.controls.date.value, 'confirm');
    })

  }
}
