package fr.loicpincon.jaccuzispa.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import fr.loicpincon.jaccuzispa.repository.entity.SoireeJaccuzEntity;
import fr.loicpincon.jaccuzispa.repository.repository.SoireeJaccuzRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SoireeSpaServiceTest {

  @InjectMocks
  private SoireeSpaService service;

  @Mock
  private SoireeJaccuzRepository soireeJaccuzRepository;

  @Mock
  private  SpaService spaService;



  @Test
  void should_be_refuse_party() {
    // GIVEN
    Mockito.when(soireeJaccuzRepository.findAllByFinish(false)).thenReturn(List.of(build(LocalDateTime.of(2022, 1, 6, 22, 0, 0))));
    // WHEN
    assertThatThrownBy(() -> service.planning(LocalDateTime.of(2022, 1, 6, 20, 0, 0), 12));

    // THEN

  }

  private SoireeJaccuzEntity build(LocalDateTime of) {
    SoireeJaccuzEntity soireeJaccuzEntity = new SoireeJaccuzEntity();
    soireeJaccuzEntity.setStartAt(of);
    return soireeJaccuzEntity;
  }


}