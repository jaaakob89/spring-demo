package pl.mpas.demo_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "domek"})
    public String home() {
        return "index";
    }
}
