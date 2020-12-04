package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Manufacturer;
import ua.lviv.iot.terminal.repository.ManufacturerRepository;

@Service
public class ManufacturerService extends AbstractService<Manufacturer> {
  @Autowired
  public ManufacturerService(final ManufacturerRepository manufacturerRepository) {
    super(manufacturerRepository);
  }
}
