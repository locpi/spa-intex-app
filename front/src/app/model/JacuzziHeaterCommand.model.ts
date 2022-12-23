import {Injectable} from "@angular/core";
import {AbstractCommand} from "./AbstractCommand";

@Injectable({
  providedIn: 'root',
})
export class JacuzziHeaterCommand extends AbstractCommand{

  constructor() {
    super('Chauffage');
  }

}
