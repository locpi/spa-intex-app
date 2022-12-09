package fr.loicpincon.jaccuzispa.rest.vm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpaInformation {

  private int tempAct;

  private int tempSet;

  private boolean power;

  private boolean filter;

  private boolean heater;

  private boolean bubble;

}
