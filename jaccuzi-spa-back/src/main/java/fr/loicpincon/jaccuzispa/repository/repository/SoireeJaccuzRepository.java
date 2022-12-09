package fr.loicpincon.jaccuzispa.repository.repository;

import fr.loicpincon.jaccuzispa.repository.entity.SoireeJaccuzEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class SoireeJaccuzRepository {

  private static final List<SoireeJaccuzEntity> DATABASE = new ArrayList<>();


  public void create(LocalDateTime localDateTime, int temp) {
    SoireeJaccuzEntity soireeJaccuzEntity = new SoireeJaccuzEntity();
    soireeJaccuzEntity.setStartAt(localDateTime);
    soireeJaccuzEntity.setId(DATABASE.size());
    soireeJaccuzEntity.setTemperature(temp);
    DATABASE.add(soireeJaccuzEntity);
  }

  public List<SoireeJaccuzEntity> getAllNoFinish() {
    return DATABASE.stream().filter(f -> !f.isFinish()).collect(Collectors.toList());
  }


}
