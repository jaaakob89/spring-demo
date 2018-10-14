package pl.mpas.demo_spring.dao;

import org.springframework.data.repository.CrudRepository;
import pl.mpas.demo_spring.dto.Address;

public interface AddressDao extends CrudRepository<Address, Long> {
}
