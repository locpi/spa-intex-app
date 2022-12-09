package fr.loicpincon.jaccuzispa.repository;

import fr.loicpincon.jaccuzispa.repository.entity.TemperatureHistoryEntity;
import fr.loicpincon.jaccuzispa.rest.vm.TemperatureHistory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureHistoryRepository extends MongoRepository<TemperatureHistoryEntity, String> {

  List<TemperatureHistory> findAllByDateIsAfter(LocalDateTime minusDays);

  Optional<TemperatureHistory> findByDateIs(LocalDateTime minusDays);

}
