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
import ua.lviv.iot.terminal.domain.Country;
import ua.lviv.iot.terminal.service.CountryService;

@RestController
@RequestMapping(value = "api/country", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController extends AbstractController<Country> {

  @Autowired
  public CountryController(CountryService countryService) {
    super(countryService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Country> updateObject(@PathVariable final Integer id,
                                              @RequestBody final Country country) {
    country.setId(id);
    Country oldCountry = service.updateObject(id, country, new Country());
    return oldCountry == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldCountry, HttpStatus.OK);
  }
}
