package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Sex;
import ua.lviv.iot.terminal.repository.SexRepository;

@Service
public class SexService extends AbstractService<Sex> {
  @Autowired
  public SexService(final SexRepository sexRepository) {
    super(sexRepository);
  }
}
