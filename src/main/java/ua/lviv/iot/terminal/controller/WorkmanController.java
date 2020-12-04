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
import ua.lviv.iot.terminal.domain.Workman;
import ua.lviv.iot.terminal.service.WorkmanService;

@RestController
@RequestMapping(value = "api/workman", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkmanController extends AbstractController<Workman> {

  @Autowired
  public WorkmanController(WorkmanService workmanService) {
    super(workmanService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Workman> updateObject(@PathVariable final Integer id,
                                              @RequestBody final Workman workman) {
    workman.setId(id);
    Workman oldWorkman = service.updateObject(id, workman, new Workman());
    return oldWorkman == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldWorkman, HttpStatus.OK);
  }
}
