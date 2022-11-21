package com.gyak_bead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class GyakBeadApplication {

    public static void main(String[] args) {
        SpringApplication.run(GyakBeadApplication.class, args);
    }

    @GetMapping("/nyito")
    public String nyito(){
        return "nyito";
    }

/*
    @GetMapping("/login")
    public String login(){
        return "redirect:/login";
    }

 */
}
