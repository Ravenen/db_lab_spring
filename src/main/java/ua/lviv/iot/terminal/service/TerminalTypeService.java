package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.TerminalType;
import ua.lviv.iot.terminal.repository.TerminalTypeRepository;

@Service
public class TerminalTypeService extends AbstractService<TerminalType> {
  @Autowired
  public TerminalTypeService(final TerminalTypeRepository terminalTypeRepository) {
    super(terminalTypeRepository);
  }
}
