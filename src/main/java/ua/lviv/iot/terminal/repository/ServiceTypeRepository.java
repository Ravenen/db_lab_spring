package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
