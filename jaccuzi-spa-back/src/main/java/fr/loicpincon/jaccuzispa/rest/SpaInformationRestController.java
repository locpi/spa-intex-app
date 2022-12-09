package fr.loicpincon.jaccuzispa.rest;

import fr.loicpincon.jaccuzispa.repository.entity.JavaSpaInformationsEntity;
import fr.loicpincon.jaccuzispa.rest.vm.SpaInformation;
import fr.loicpincon.jaccuzispa.rest.vm.SpaInformation.TemperatureInformation;
import fr.loicpincon.jaccuzispa.service.SpaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpaInformationRestController {

  private final SpaService service;

  @GetMapping("/api/v1/spa/information")
  public SpaInformation get() {
    JavaSpaInformationsEntity javaSpaInformationsEntity = service.get();
    SpaInformation spaInformation = new SpaInformation();
    spaInformation.setBubble(javaSpaInformationsEntity.isBubble());

    spaInformation.setTempAct(
        TemperatureInformation.builder()
                              .refreshDate(javaSpaInformationsEntity.getTempActRefreshDate())
                              .value(javaSpaInformationsEntity.getTempAct())
                              .build()
    );
    spaInformation.setPower(javaSpaInformationsEntity.isPower());
    spaInformation.setHeater(javaSpaInformationsEntity.isHeater());
    spaInformation.setFilter(javaSpaInformationsEntity.isFilter());
    spaInformation.setTempSet(
        TemperatureInformation.builder()
                              .refreshDate(javaSpaInformationsEntity.getTempSetRefreshDate())
                              .value(javaSpaInformationsEntity.getTempSet())
                              .build()
    );
    return spaInformation;
  }

}
