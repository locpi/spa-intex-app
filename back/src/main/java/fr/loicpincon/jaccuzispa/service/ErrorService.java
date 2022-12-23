package fr.loicpincon.jaccuzispa.service;

import fr.loicpincon.jaccuzispa.repository.entity.ErrorMessageEntity;
import fr.loicpincon.jaccuzispa.repository.repository.ErrorMessageRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ErrorService {

  private final ErrorMessageRepository errorMessageRepository;

  public void saveError(String message) {

    errorMessageRepository.findBySee(false).ifPresent(see -> {
      see.setSee(true);
      errorMessageRepository.save(see);
    });

    ErrorMessageEntity entity = new ErrorMessageEntity();
    entity.setTime(LocalDateTime.now());
    entity.setMessage(message);
    entity.setSee(false);
    errorMessageRepository.save(entity);
  }

  public void deleteError() {
    errorMessageRepository.findBySee(false).ifPresent(see -> {
      see.setSee(true);
      errorMessageRepository.save(see);
    });
  }

  public ErrorMessageEntity getError() {
   return errorMessageRepository.findBySee(false).orElse(null);
  }
}
