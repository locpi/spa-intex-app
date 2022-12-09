package fr.loicpincon.jaccuzispa.rest;

import fr.loicpincon.jaccuzispa.rest.vm.PartyVm;
import fr.loicpincon.jaccuzispa.service.SoireeSpaService;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PartyRestController {

  private final SoireeSpaService service;

  @GetMapping("/api/v1/party")
  public List<PartyVm> create() {
    return service.getAllAVenir().stream().map(f -> {
      PartyVm partyVm = new PartyVm();
      partyVm.setStartAt(Date.from(f.getStartAt().atZone(ZoneId.systemDefault()).toInstant()));
      partyVm.setTemp(f.getTemperature());
      return partyVm;
    }).collect(Collectors.toList());

  }

  @PostMapping("/api/v1/party")
  public void create(@RequestBody PartyVm partyVm) {
    LocalDateTime localDateTime = Instant.ofEpochMilli(partyVm.getStartAt().getTime())
                                         .atZone(ZoneId.systemDefault())
                                         .toLocalDateTime();
    service.planning(localDateTime, partyVm.getTemp());

  }

}
