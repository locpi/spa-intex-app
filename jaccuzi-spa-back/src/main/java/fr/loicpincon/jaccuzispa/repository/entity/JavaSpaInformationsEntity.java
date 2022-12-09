package fr.loicpincon.jaccuzispa.repository.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JavaSpaInformationsEntity {

  private int tempAct;

  private int tempSet;

  private int tempNightSet;

  private boolean power;

  private boolean filter;

  private boolean heater;

  private boolean bubble;


}
