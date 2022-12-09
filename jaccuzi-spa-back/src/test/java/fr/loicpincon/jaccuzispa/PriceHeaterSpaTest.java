package fr.loicpincon.jaccuzispa;

import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceHeaterSpaTest {

  @Test
  void verify_hours() {
    LocalDateTime of = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
    PriceHeaterSpa priceHeaterSpa = new PriceHeaterSpa();

    List<Integer> integers = List.of(2, 3, 4, 5,
                                     6, 7, 15, 16);

    for (int i = 0; i < 24; i++) {
      LocalDateTime localDateTime = of.plusHours(i);
      if (integers.contains(localDateTime.getHour())) {
        Assertions.assertThat(priceHeaterSpa.isHighHour(localDateTime)).isFalse();
      } else {
        Assertions.assertThat(priceHeaterSpa.isHighHour(localDateTime)).isTrue();
      }
    }
  }

  @Test
  void test() {
    PriceHeaterSpa priceHeaterSpa = new PriceHeaterSpa();

    String priceForOneDayHeater = priceHeaterSpa.getPriceForOneDayHeater();
    System.out.println(priceForOneDayHeater);
    System.out.println(priceHeaterSpa.getPriceForOneDayBubble());
    System.out.println(priceHeaterSpa.getPriceForOneDayFilter());

  }
}