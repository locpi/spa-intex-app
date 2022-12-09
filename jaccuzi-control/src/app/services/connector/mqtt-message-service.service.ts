import {Injectable} from "@angular/core";
import {MqttService} from "ngx-mqtt";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root',
})
export class MqttMessageService {


  constructor(private _mqttService: MqttService) {
    this._mqttService.observe(environment.topics.get_error).subscribe(r=>{
      console.log(r.payload.toString())
    },error => alert(error))
  }

  public sendMessage(topic: string, payload: string): void {
      console.log('Publish', payload, topic);
      this._mqttService.unsafePublish(topic, payload, {
      });
  }

  public observe(topic: string): Observable<any> {
    return this._mqttService.observe(topic);
  }

  ngOnDestroy() {
    console.log('ngOnDestroy: cleaning up...');
    this._mqttService.disconnect();
  }

}
