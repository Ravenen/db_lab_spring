package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
