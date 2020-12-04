package ua.lviv.iot.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.terminal.domain.ServiceEntity;
import ua.lviv.iot.terminal.repository.ServiceEntityRepository;

@Service
public class ServiceEntityService extends AbstractService<ServiceEntity> {
  @Autowired
  public ServiceEntityService(final ServiceEntityRepository serviceEntityRepository) {
    super(serviceEntityRepository);
  }
}
