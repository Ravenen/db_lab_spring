package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.terminal.domain.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
}
