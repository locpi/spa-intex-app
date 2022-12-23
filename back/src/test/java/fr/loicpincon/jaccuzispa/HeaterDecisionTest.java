package fr.loicpincon.jaccuzispa;

import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HeaterDecisionTest {

  @Test
  void should_be_start_heater() {
    // GIVEN
    HeaterDecision build = HeaterDecision.builder()
                                         .tempAct(12)
                                         .tempSet(20)
                                         .forTime(LocalDateTime.of(2022, 1, 6, 22, 0, 0))
                                         .actualTime(LocalDateTime.of(2022, 1, 6, 18, 0, 0))
                                         .build();

    // WHEN
    boolean b = build.startHeater();

    // THEN
    Assertions.assertThat(b).isTrue();
  }


  @Test
  void should_be_not_start_heater() {
    // GIVEN
    HeaterDecision build = HeaterDecision.builder()
                                         .tempAct(12)
                                         .tempSet(20)
                                         .forTime(LocalDateTime.of(2022, 1, 6, 22, 0, 0))
                                         .actualTime(LocalDateTime.of(2022, 1, 5, 10, 0, 0))
                                         .build();

    // WHEN
    boolean b = build.startHeater();

    // THEN
    Assertions.assertThat(b).isFalse();
  }

  @Test
  void should_be_return_temp_at_final_hour() {
    // GIVEN
    HeaterDecision build = HeaterDecision.builder()
                                         .tempAct(12)
                                         .tempSet(20)
                                         .forTime(LocalDateTime.of(2022, 1, 6, 22, 0, 0))
                                         .actualTime(LocalDateTime.of(2022, 1, 6, 20, 0, 0))
                                         .build();

    // WHEN
    long b = build.finalTemperatureForTime();

    // THEN
    Assertions.assertThat(b).isEqualTo(16);
  }

}