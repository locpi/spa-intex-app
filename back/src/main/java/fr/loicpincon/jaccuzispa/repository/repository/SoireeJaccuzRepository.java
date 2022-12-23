package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.SoireeJaccuzEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoireeJaccuzRepository extends MongoRepository<SoireeJaccuzEntity, String> {

  List<SoireeJaccuzEntity> findAllByFinish(boolean b);

}
