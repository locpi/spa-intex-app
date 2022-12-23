import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {IonicModule} from "@ionic/angular";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Tab1PageRoutingModule} from "../tab1/tab1-routing.module";
import {PlanningRoutingModule} from "./planning-routing.module";
import {HomeComponent} from "./home/home.component";
import {AddComponent} from "./add/add.component";



@NgModule({
  declarations: [HomeComponent,AddComponent],
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    PlanningRoutingModule,
    ReactiveFormsModule
  ]
})
export class PlanningModule { }
