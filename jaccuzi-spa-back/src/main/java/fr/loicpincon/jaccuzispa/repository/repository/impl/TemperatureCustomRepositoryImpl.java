package fr.loicpincon.jaccuzispa.repository.repository.impl;

import fr.loicpincon.jaccuzispa.repository.entity.TemperatureHistoryEntity;
import fr.loicpincon.jaccuzispa.repository.repository.TemperatureCustomRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

@RequiredArgsConstructor
public class TemperatureCustomRepositoryImpl implements TemperatureCustomRepository {

  private final MongoTemplate mongoTemplate;

  @Override
  public Optional<TemperatureHistoryEntity> findFirstOrderByDateDesc() {
    final Query query = new Query()
        .limit(1)
        .with(Sort.by(Sort.Direction.DESC, "date"));

    return Optional.ofNullable(mongoTemplate.findOne(query, TemperatureHistoryEntity.class));
  }
}
