package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Region;
import ua.lviv.iot.terminal.repository.RegionRepository;

@Service
public class RegionService extends AbstractService<Region> {
  @Autowired
  public RegionService(final RegionRepository regionRepository) {
    super(regionRepository);
  }
}
