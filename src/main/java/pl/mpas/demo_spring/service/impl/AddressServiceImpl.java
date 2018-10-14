package pl.mpas.demo_spring.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.mpas.demo_spring.dao.AddressDao;
import pl.mpas.demo_spring.dto.Address;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(AddressServiceImpl.class);

    private AddressDao dataSource;
    public AddressServiceImpl(AddressDao dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<Address> findAllAdresses() {
        logger.info("findAllAddresses");

        List<Address> result = new ArrayList<>();
        dataSource.findAll().forEach(result::add);
        dataSource.findAll().forEach(e -> result.add(e));



        return result;
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
       logger.info("findAddressById() with id:  {}", id);

       Optional<Address> result = dataSource.findById(id);
       result.ifPresent(address -> logger.info("Addresses read from dao: {}",id));

        return result;
    }
}
