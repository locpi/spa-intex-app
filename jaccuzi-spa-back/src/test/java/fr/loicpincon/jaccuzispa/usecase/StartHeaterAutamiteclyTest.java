package fr.loicpincon.jaccuzispa.usecase;

import static java.time.LocalDateTime.now;
import static org.mockito.Mockito.times;

import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import fr.loicpincon.jaccuzispa.repository.entity.SoireeJaccuzEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SoireeJaccuzRepository;
import fr.loicpincon.jaccuzispa.service.SpaService;
import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StartHeaterAutamiteclyTest {

  @InjectMocks
  private StartHeaterAutamitecly startHeaterAutamitecly;

  @Mock
  private SoireeJaccuzRepository soireeJaccuzRepository;

  @Mock
  private SpaService service;

  @Test
  void should_be_start_heater() throws MqttException {
    // GIVEN
    LocalDateTime nowMinusTenHours = now().minusHours(10);

    Mockito.when(soireeJaccuzRepository.findAllByFinish(false))
           .thenReturn(List.of(build(nowMinusTenHours, 40)));

    Mockito.when(service.get()).thenReturn(getT(20));

    // WHEN
    startHeaterAutamitecly.execute();
    // THEN
    Mockito.verify(service, times(1)).startHeater();

  }

  @Test
  void should_be_not_start_heater_because_party_is_tomorrow() throws MqttException {
    // GIVEN
    LocalDateTime tommorow = now().plusDays(1);
    Mockito.when(soireeJaccuzRepository.findAllByFinish(false)).thenReturn(List.of(build(tommorow, 40)));

    Mockito.when(service.get()).thenReturn(getT(20));

    // WHEN
    startHeaterAutamitecly.execute();
    // THEN
    Mockito.verify(service, times(0)).startHeater();

  }

  @Test
  void should_throw_exception_because_temperature_will_never_possible() throws MqttException {
    // GIVEN

    LocalDateTime nowMinusTwoHours = now().minusHours(2);

    Mockito.when(soireeJaccuzRepository.findAllByFinish(false))
           .thenReturn(List.of(build(nowMinusTwoHours, 40)));

    Mockito.when(service.get()).thenReturn(getT(20));

    // WHEN
    Assertions.assertThatThrownBy(() -> startHeaterAutamitecly.execute()).isInstanceOf(RuntimeException.class);
    // THEN

    Mockito.verify(service, times(0)).startHeater();

  }

  private static JavaSpaInformationsEntity getT(int temp) {
    JavaSpaInformationsEntity javaSpaInformationsEntity = new JavaSpaInformationsEntity();
    javaSpaInformationsEntity.setTempAct(temp);
    return javaSpaInformationsEntity;
  }

  private SoireeJaccuzEntity build(LocalDateTime of, int temp) {
    SoireeJaccuzEntity soireeJaccuzEntity = new SoireeJaccuzEntity();
    soireeJaccuzEntity.setStartAt(of);
    soireeJaccuzEntity.setTemperature(temp);
    return soireeJaccuzEntity;
  }


}
