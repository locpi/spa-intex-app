package fr.loicpincon.jaccuzispa.rest.vm;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorMessageVm {

  private final LocalDateTime time;
  private final String raison;

}
