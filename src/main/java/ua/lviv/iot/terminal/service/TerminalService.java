package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Terminal;
import ua.lviv.iot.terminal.repository.TerminalRepository;

@Service
public class TerminalService extends AbstractService<Terminal> {
  @Autowired
  public TerminalService(final TerminalRepository terminalRepository) {
    super(terminalRepository);
  }
}
