package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Country;
import ua.lviv.iot.terminal.repository.CountryRepository;

@Service
public class CountryService extends AbstractService<Country> {
  @Autowired
  public CountryService(final CountryRepository countryRepository) {
    super(countryRepository);
  }
}
