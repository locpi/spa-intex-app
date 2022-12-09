package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.TemperatureHistoryEntity;
import java.util.Optional;

public interface TemperatureCustomRepository {

  Optional<TemperatureHistoryEntity> findFirstOrderByDateDesc();

}
