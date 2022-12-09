package fr.loicpincon.jaccuzispa.service;

import fr.loicpincon.jaccuzispa.repository.TemperatureHistoryRepository;
import fr.loicpincon.jaccuzispa.repository.entity.TemperatureHistoryEntity;
import fr.loicpincon.jaccuzispa.rest.vm.TemperatureHistory;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemperatureHistoryService {


  private final TemperatureHistoryRepository temperatureHistoryRepository;

  public void addStats(int value) {
    LocalDateTime now = LocalDateTime.now();

    LocalDateTime of = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), 0, 0);

    boolean present = temperatureHistoryRepository.findByDateIs(of).isPresent();
    if(!present){
      temperatureHistoryRepository.save(TemperatureHistoryEntity.builder()
                                                                .date(of)
                                                                .value(value)
                                                                .build());
    }

  }

  public List<TemperatureHistory> getTwoLastDays() {
    List<TemperatureHistory> allByDateIsAfter = temperatureHistoryRepository.findAllByDateIsAfter(LocalDateTime.now().minusDays(2));

    return allByDateIsAfter;
  }
}
