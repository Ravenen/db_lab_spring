package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.Sex;

public interface SexRepository extends JpaRepository<Sex, Integer> {
}
