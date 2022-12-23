package fr.loicpincon.jaccuzispa.rest;

import fr.loicpincon.jaccuzispa.repository.entity.ErrorMessageEntity;
import fr.loicpincon.jaccuzispa.rest.vm.ErrorMessageVm;
import fr.loicpincon.jaccuzispa.service.ErrorService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/spa/error")
@RequiredArgsConstructor
public class ErrorRestController {

  private final ErrorService errorService;

  @GetMapping
  public Object getError() {
    ErrorMessageEntity error = errorService.getError();
    if (Objects.isNull(error)) {
      return null;
    }
    return ErrorMessageVm.builder().raison(error.getMessage()).time(error.getTime()).build();
  }

  @DeleteMapping
  public void deleteError() {
    errorService.deleteError();
  }

}
