package fr.loicpincon.jaccuzispa.rest;

import fr.loicpincon.jaccuzispa.repository.entity.WifiInformationsEntity;
import fr.loicpincon.jaccuzispa.rest.vm.WifiInformationsVm;
import fr.loicpincon.jaccuzispa.service.WifiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WifiInformationRestController {

  private final WifiService wifiService;

  @GetMapping("/api/v1/wifi/information")
  public WifiInformationsVm get() {
    WifiInformationsEntity wifiInformationsEntity = wifiService.get();
    WifiInformationsVm wifiInformationsVm = new WifiInformationsVm();
    wifiInformationsVm.setIp(wifiInformationsEntity.getIp());
    wifiInformationsVm.setRssi(wifiInformationsEntity.getRssi());
    wifiInformationsVm.setVersion(wifiInformationsEntity.getVersion());
    wifiInformationsVm.setState(wifiInformationsEntity.getState());
    return wifiInformationsVm;
  }

}
