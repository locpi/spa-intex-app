package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.TemperatureHistoryEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureHistoryRepository extends MongoRepository<TemperatureHistoryEntity, String>, TemperatureCustomRepository {

  List<TemperatureHistoryEntity> findAllByDateIsAfter(LocalDateTime minusDays);


}
