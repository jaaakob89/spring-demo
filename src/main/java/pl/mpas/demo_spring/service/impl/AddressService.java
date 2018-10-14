package pl.mpas.demo_spring.service.impl;

import pl.mpas.demo_spring.dto.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> findAllAdresses();

    Optional<Address> findAddressById(Long id);
}
