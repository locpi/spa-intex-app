package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaRepository extends MongoRepository<JavaSpaInformationsEntity, String> {

  default JavaSpaInformationsEntity getJavaSpaInformationsEntity() {
    return findAll().get(0);
  }
}
