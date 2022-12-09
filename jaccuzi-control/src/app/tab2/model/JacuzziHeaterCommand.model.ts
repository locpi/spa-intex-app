import {Subject} from "rxjs";
import {DefaultCommand} from "./DefaultCommand.model";
import {BubbleService} from "../../services/bubble-service.service";
import {Injectable} from "@angular/core";
import {HeaterService} from "../../services/heater-service.service";
import {AbstractCommand} from "./AbstractCommand";

@Injectable({
  providedIn: 'root',
})
export class JacuzziHeaterCommand extends AbstractCommand{

  constructor() {
    super('Chauffage');
  }

}
