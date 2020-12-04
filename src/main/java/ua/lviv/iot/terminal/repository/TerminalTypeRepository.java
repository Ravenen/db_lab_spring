package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.TerminalType;

public interface TerminalTypeRepository extends JpaRepository<TerminalType, Integer> {
}
