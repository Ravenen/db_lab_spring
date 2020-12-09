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
import ua.lviv.iot.terminal.domain.Region;
import ua.lviv.iot.terminal.service.RegionService;

@RestController
@RequestMapping(value = "api/region", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionController extends AbstractController<Region> {

  @Autowired
  public RegionController(RegionService regionService) {
    super(regionService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Region> updateObject(@PathVariable final Integer id,
                                             @RequestBody final Region region) {
    region.setId(id);
    Region oldRegion = service.updateObject(id, region, new Region());
    return oldRegion == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldRegion, HttpStatus.OK);
  }
}
