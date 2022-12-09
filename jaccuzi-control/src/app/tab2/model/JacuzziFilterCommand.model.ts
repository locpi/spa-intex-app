import {DefaultCommand} from "./DefaultCommand.model";
import {Injectable} from "@angular/core";
import {FilterService} from "../../services/filter-service.service";
import {AbstractCommand} from "./AbstractCommand";

@Injectable({
  providedIn: 'root',
})
export class JacuzziFilterCommand extends AbstractCommand {

  constructor() {
    super('Filtration');
  }


}
