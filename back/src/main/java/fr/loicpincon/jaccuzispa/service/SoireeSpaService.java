package fr.loicpincon.jaccuzispa.service;

import static fr.loicpincon.jaccuzispa.repository.entity.SoireeJaccuzEntity.SESSION_DURATION_HOURS;
import static java.time.temporal.ChronoUnit.HOURS;

import fr.loicpincon.jaccuzispa.HeaterDecision;
import fr.loicpincon.jaccuzispa.repository.entity.SoireeJaccuzEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SoireeJaccuzRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoireeSpaService {

  private final SoireeJaccuzRepository soireeJaccuzRepository;

  private final SpaService spaService;

  public void planning(LocalDateTime newSession, int temp) {

    List<SoireeJaccuzEntity> allNoFinish = soireeJaccuzRepository.findAllByFinish(false);

    boolean present = allNoFinish.stream()
                                 .anyMatch(f -> newSession.isBefore(f.getStartAt().plus(SESSION_DURATION_HOURS, HOURS)));

    if (present) {
      throw new RuntimeException("Impossible de creer une session par dessus une autre");
    }

    HeaterDecision build = HeaterDecision.builder()
                                         .tempSet(temp)
                                         .tempAct(spaService.get().getTempAct())
                                         .forTime(newSession)
                                         .actualTime(LocalDateTime.now())
                                         .build();

    if (build.diffTemperatureForTime() > 3) {
      throw new RuntimeException("La temperature sera differente de plus de 3 degres, soirée annulé");
    }

    SoireeJaccuzEntity soireeJaccuzEntity = new SoireeJaccuzEntity();
    soireeJaccuzEntity.setTemperature(temp);
    soireeJaccuzEntity.setFinish(false);
    soireeJaccuzEntity.setStartAt(newSession);

    soireeJaccuzRepository.save(soireeJaccuzEntity);
  }

  public List<SoireeJaccuzEntity> getAllAVenir() {
    return soireeJaccuzRepository.findAllByFinish(false);
  }

}
