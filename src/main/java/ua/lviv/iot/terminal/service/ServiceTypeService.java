package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.ServiceType;
import ua.lviv.iot.terminal.repository.ServiceTypeRepository;

@Service
public class ServiceTypeService extends AbstractService<ServiceType> {
  @Autowired
  public ServiceTypeService(final ServiceTypeRepository serviceTypeRepository) {
    super(serviceTypeRepository);
  }
}
