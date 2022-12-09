package fr.loicpincon.jaccuzispa.cron;

import fr.loicpincon.jaccuzispa.usecase.HeaterOnlyDuringLowerEdfHours;
import fr.loicpincon.jaccuzispa.usecase.StartHeaterAutamitecly;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CronApp {


  private final StartHeaterAutamitecly startHeaterAutamitecly;

  private final HeaterOnlyDuringLowerEdfHours heaterOnlyDuringLowerEdfHours;


  @Scheduled(cron = "0 */5 * ? * *")
  public void scanToStartHeater() {
    log.info("Start scan heater auto");

    startHeaterAutamitecly.execute();
  }

  @Scheduled(cron = "0 0 2 * * ?")
  public void startHeaterAtNight() throws MqttException {
    log.info("Start heater night");
    heaterOnlyDuringLowerEdfHours.start();
  }

  @Scheduled(cron = "0 0 8 * * ?")
  public void startHeaterAtMorning() {
    log.info("Stop heater night");
    heaterOnlyDuringLowerEdfHours.stop();
  }




}
