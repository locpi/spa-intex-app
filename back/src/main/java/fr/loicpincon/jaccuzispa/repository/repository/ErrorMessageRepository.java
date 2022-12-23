package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.ErrorMessageEntity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorMessageRepository extends MongoRepository<ErrorMessageEntity, String> {

  Optional<ErrorMessageEntity> findBySee(boolean see);

}
