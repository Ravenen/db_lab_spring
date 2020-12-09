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
import ua.lviv.iot.terminal.domain.Sex;
import ua.lviv.iot.terminal.service.SexService;

@RestController
@RequestMapping(value = "api/sex", produces = MediaType.APPLICATION_JSON_VALUE)
public class SexController extends AbstractController<Sex> {

  @Autowired
  public SexController(SexService sexService) {
    super(sexService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Sex> updateObject(@PathVariable final Integer id,
                                          @RequestBody final Sex sex) {
    sex.setId(id);
    Sex oldSex = service.updateObject(id, sex, new Sex());
    return oldSex == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldSex, HttpStatus.OK);
  }
}
