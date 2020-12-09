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
import ua.lviv.iot.terminal.domain.City;
import ua.lviv.iot.terminal.service.CityService;

@RestController
@RequestMapping(value = "api/city", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController extends AbstractController<City> {

  @Autowired
  public CityController(CityService cityService) {
    super(cityService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<City> updateObject(@PathVariable final Integer id,
                                           @RequestBody final City city) {
    city.setId(id);
    City oldCity = service.updateObject(id, city, new City());
    return oldCity == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldCity, HttpStatus.OK);
  }
}
