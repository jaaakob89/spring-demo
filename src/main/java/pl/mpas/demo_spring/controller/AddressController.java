package pl.mpas.demo_spring.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mpas.demo_spring.dto.Address;
import pl.mpas.demo_spring.service.impl.AddressService;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class AddressController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(AddressController.class);

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/all-addresses")
    public String showAllAdresses(Model model){
        logger.info("showAllAdresses()");

        List<Address> allAddr = addressService.findAllAdresses();
        model.addAttribute("addresses",allAddr );

        return "address/all";

    }

}
