package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.ServiceEntity;

public interface ServiceEntityRepository extends JpaRepository<ServiceEntity, Integer> {
}
