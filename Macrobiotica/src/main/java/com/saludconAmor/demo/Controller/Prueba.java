package com.saludconAmor.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Prueba {

@GetMapping("/")
public String getMethodName() {
    return "a   ";
}

}
