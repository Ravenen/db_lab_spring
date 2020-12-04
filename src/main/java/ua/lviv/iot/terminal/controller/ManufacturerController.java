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
import ua.lviv.iot.terminal.domain.Manufacturer;
import ua.lviv.iot.terminal.service.ManufacturerService;

@RestController
@RequestMapping(value = "api/manufacturer", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManufacturerController extends AbstractController<Manufacturer> {

  @Autowired
  public ManufacturerController(ManufacturerService manufacturerService) {
    super(manufacturerService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Manufacturer> updateObject(@PathVariable final Integer id,
                                                   @RequestBody final Manufacturer manufacturer) {
    manufacturer.setId(id);
    Manufacturer oldManufacturer = service.updateObject(id, manufacturer, new Manufacturer());
    return oldManufacturer == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldManufacturer, HttpStatus.OK);
  }
}
