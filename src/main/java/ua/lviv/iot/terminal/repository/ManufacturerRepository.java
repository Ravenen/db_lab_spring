package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
