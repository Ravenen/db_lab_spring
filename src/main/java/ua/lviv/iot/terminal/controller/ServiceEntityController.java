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
import ua.lviv.iot.terminal.domain.ServiceEntity;
import ua.lviv.iot.terminal.service.ServiceEntityService;

@RestController
@RequestMapping(value = "api/serviceEntity", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceEntityController extends AbstractController<ServiceEntity> {

  @Autowired
  public ServiceEntityController(ServiceEntityService serviceEntityService) {
    super(serviceEntityService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<ServiceEntity> updateObject(@PathVariable final Integer id,
                                                    @RequestBody
                                                    final ServiceEntity serviceEntity) {
    serviceEntity.setId(id);
    ServiceEntity oldServiceEntity = service.updateObject(id, serviceEntity, new ServiceEntity());
    return oldServiceEntity == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldServiceEntity, HttpStatus.OK);
  }
}
