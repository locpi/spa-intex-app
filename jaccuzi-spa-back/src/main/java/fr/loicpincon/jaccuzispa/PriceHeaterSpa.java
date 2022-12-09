package fr.loicpincon.jaccuzispa;

import java.time.LocalDateTime;

public class PriceHeaterSpa {

  private final double chauffage = 2.2;
  private final double bulle = 0.8;
  private final double filtration = 0.005;

  private final double kwPriceHighHours = 0.1841;
  private final double kwPriceLowHours = 0.1470;

  public boolean isHighHour(LocalDateTime nowDate) {
    int now = nowDate.getHour();
    if (now < 2) {
      return true;
    } else if (now < 8) {
      return false;
    } else if (now < 15) {
      return true;
    } else if (now < 17) {
      return false;
    } else {
      return true;
    }

  }

  public String getPriceForOneDayHeater() {
    LocalDateTime of = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
    double price = 0;
    for (int i = 0; i < 24; i++) {
      of = of.plusHours(i);
      if (isHighHour(of)) {
        price = price + chauffage * kwPriceHighHours;
      } else {
        price = price + chauffage * kwPriceLowHours;
      }
    }
    return price + " euros";
  }

  public String getPriceForOneDayBubble() {
    LocalDateTime of = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
    double price = 0;
    for (int i = 0; i < 24; i++) {
      of = of.plusHours(i);
      if (isHighHour(of)) {
        price = price + bulle * kwPriceHighHours;
      } else {
        price = price + bulle * kwPriceLowHours;
      }
    }
    return price + " euros";
  }

  public String getPriceForOneDayFilter() {
    LocalDateTime of = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
    double price = 0;
    for (int i = 0; i < 24; i++) {
      of = of.plusHours(i);
      if (isHighHour(of)) {
        price = price + filtration * kwPriceHighHours;
      } else {
        price = price + filtration * kwPriceLowHours;
      }
    }
    return price + " euros";
  }
}
