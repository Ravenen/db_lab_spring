package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
