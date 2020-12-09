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
import ua.lviv.iot.terminal.domain.TerminalType;
import ua.lviv.iot.terminal.service.TerminalTypeService;

@RestController
@RequestMapping(value = "api/terminalType", produces = MediaType.APPLICATION_JSON_VALUE)
public class TerminalTypeController extends AbstractController<TerminalType> {

  @Autowired
  public TerminalTypeController(TerminalTypeService terminalTypeService) {
    super(terminalTypeService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<TerminalType> updateObject(@PathVariable final Integer id,
                                                   @RequestBody final TerminalType terminalType) {
    terminalType.setId(id);
    TerminalType oldTerminalType = service.updateObject(id, terminalType, new TerminalType());
    return oldTerminalType == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldTerminalType, HttpStatus.OK);
  }
}
