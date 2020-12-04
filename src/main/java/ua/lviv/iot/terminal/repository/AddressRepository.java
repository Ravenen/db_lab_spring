package ua.lviv.iot.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.terminal.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
