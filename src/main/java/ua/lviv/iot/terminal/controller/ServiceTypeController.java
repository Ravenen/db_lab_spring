package ua.lviv.iot.terminal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.terminal.domain.ServiceType;
import ua.lviv.iot.terminal.service.ServiceTypeService;

@RestController
@RequestMapping(value = "api/serviceType", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceTypeController extends AbstractController<ServiceType> {

  @Autowired
  public ServiceTypeController(ServiceTypeService serviceTypeService) {
    super(serviceTypeService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<ServiceType> updateObject(@PathVariable final Integer id,
                                                  @RequestBody final ServiceType serviceType) {
    serviceType.setId(id);
    ServiceType oldServiceType = service.updateObject(id, serviceType, new ServiceType());
    return oldServiceType == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldServiceType, HttpStatus.OK);
  }
}
