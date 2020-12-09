package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.City;
import ua.lviv.iot.terminal.repository.CityRepository;

@Service
public class CityService extends AbstractService<City> {

  @Autowired
  public CityService(final CityRepository cityRepository) {
    super(cityRepository);
  }
}
