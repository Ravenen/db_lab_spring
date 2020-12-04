package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Workman;
import ua.lviv.iot.terminal.repository.WorkmanRepository;

@Service
public class WorkmanService extends AbstractService<Workman> {
  @Autowired
  public WorkmanService(final WorkmanRepository workmanRepository) {
    super(workmanRepository);
  }
}
