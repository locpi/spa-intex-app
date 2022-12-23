import {Injectable} from "@angular/core";
import {MqttMessageService} from "./connector/mqtt-message-service.service";
import {HttpClient} from "@angular/common/http";
import {Subject} from "rxjs";
import {environment} from "../../environments/environment";

export class JacuzziError {

  time!: Date;
  raison!: string;

}

@Injectable({
  providedIn: 'root',
})
export class ErrorService {

  private error: Subject<JacuzziError> = new Subject<JacuzziError>()

  constructor(private mqtt: MqttMessageService, private http: HttpClient) {
    this.http.get<JacuzziError>(environment.api.baseurl + '/api/v1/spa/error').subscribe(error => {
      this.error.next(error)
    })

    this.mqtt.observe(environment.topics.get_error).subscribe(error => {
      let jacError = new JacuzziError();
      jacError.raison = error.payload.toString();
      jacError.time = new Date();
      this.error.next(jacError);
    })

  }

  public deleteError(): void {
    this.http.delete(environment.api.baseurl + '/api/v1/spa/error').subscribe()
  }

  public getError(): Subject<JacuzziError> {
    return this.error;
  }

}
