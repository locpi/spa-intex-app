import {Injectable} from "@angular/core";
import {AbstractCommand} from "./AbstractCommand";

@Injectable({
  providedIn: 'root',
})
export class JacuzziFilterCommand extends AbstractCommand {

  constructor() {
    super('Filtration');
  }


}
