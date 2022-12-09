import {DefaultCommand} from "./DefaultCommand.model";
import {BubbleService} from "../../services/bubble-service.service";
import {Injectable} from "@angular/core";
import {AbstractCommand} from "./AbstractCommand";

@Injectable({
  providedIn: 'root',
})
export class JacuzziBubbleCommand extends AbstractCommand{

  constructor() {
    super('Bulles');
  }


}
