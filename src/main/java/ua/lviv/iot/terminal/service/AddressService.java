package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.Address;
import ua.lviv.iot.terminal.repository.AddressRepository;

@Service
public class AddressService extends AbstractService<Address> {

  @Autowired
  public AddressService(AddressRepository repository) {
    super(repository);
  }
}
