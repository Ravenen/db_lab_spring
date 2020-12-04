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
import ua.lviv.iot.terminal.domain.Terminal;
import ua.lviv.iot.terminal.service.TerminalService;

@RestController
@RequestMapping(value = "api/terminal", produces = MediaType.APPLICATION_JSON_VALUE)
public class TerminalController extends AbstractController<Terminal> {

  @Autowired
  public TerminalController(TerminalService terminalService) {
    super(terminalService);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<Terminal> updateObject(@PathVariable final Integer id,
                                               @RequestBody final Terminal terminal) {
    terminal.setId(id);
    Terminal oldTerminal = service.updateObject(id, terminal, new Terminal());
    return oldTerminal == null
        ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
        : new ResponseEntity<>(oldTerminal, HttpStatus.OK);
  }
}
