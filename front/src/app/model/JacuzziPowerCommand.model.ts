import {Injectable} from "@angular/core";
import {AbstractCommand} from "./AbstractCommand";

@Injectable({
  providedIn: 'root',
})
export class JacuzziPowerCommand extends AbstractCommand {

  constructor() {
    super('Jaccuzi');
  }

}
