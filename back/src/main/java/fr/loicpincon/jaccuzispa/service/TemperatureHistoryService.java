package fr.loicpincon.jaccuzispa.service;

import static java.time.LocalDateTime.now;

import fr.loicpincon.jaccuzispa.repository.entity.TemperatureHistoryEntity;
import fr.loicpincon.jaccuzispa.repository.repository.TemperatureHistoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemperatureHistoryService {


  private final TemperatureHistoryRepository temperatureHistoryRepository;

  public void addStats(int value) {

    temperatureHistoryRepository.findFirstOrderByDateDesc().ifPresentOrElse(temperatureHistory -> {
      if (temperatureHistory.getValue() != value) {
        temperatureHistoryRepository.save(TemperatureHistoryEntity.builder()
                                                                  .date(now())
                                                                  .value(value)
                                                                  .build());
      }
    }, () -> temperatureHistoryRepository.save(TemperatureHistoryEntity.builder()
                                                                       .date(now())
                                                                       .value(value)
                                                                       .build()));
  }

  public List<TemperatureHistoryEntity> getTwoLastDays() {
    return temperatureHistoryRepository.findAllByDateIsAfter(now().minusDays(2));
  }
}
