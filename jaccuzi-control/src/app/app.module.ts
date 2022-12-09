import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';
import { environment as env } from '../environments/environment';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {IMqttServiceOptions, MqttModule} from "ngx-mqtt";
import {apiConfigProvider, JaccuziSimulationMock} from "./jaccuzi-simulation.mock";
import {HttpClientModule} from "@angular/common/http";
import {PowerService} from "./services/power-service.service";

const MQTT_SERVICE_OPTIONS: IMqttServiceOptions = {
  hostname: env.mqtt.server,
  port: env.mqtt.port,
  path: env.mqtt.path,
  username:env.mqtt.username,
  password:env.mqtt.password,
  clientId:env.mqtt.clientId
};

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule,MqttModule.forRoot(MQTT_SERVICE_OPTIONS),HttpClientModule],
  providers: [
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    {provide: APP_INITIALIZER,multi:true, deps: [JaccuziSimulationMock], useFactory: (service:JaccuziSimulationMock) => apiConfigProvider(service)}
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
