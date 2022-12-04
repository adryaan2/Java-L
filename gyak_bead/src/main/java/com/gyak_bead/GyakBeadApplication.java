package com.gyak_bead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.*;

@Controller
@SpringBootApplication

public class GyakBeadApplication {

    @Autowired
    private Huzasrepo huzasrepo;
    @Autowired
    private Huzottrepo huzottrepo;
    @Autowired
    private Nyeremenyrepo nyeremenyrepo;

    @Autowired
    private Uzenetrepo uzenetrepo;

    public static void main(String[] args) {
        SpringApplication.run(GyakBeadApplication.class, args);
    }

    @GetMapping("/nyito")
    public String nyito(){
        return "nyito";
    }

    @GetMapping("/adatbazis")
    public String adatbazis(Model model){
        model.addAttribute("huzasok",huzasrepo.findAll());
        model.addAttribute("huzottak",huzottrepo.findAll());
        model.addAttribute("nyeremenyek",nyeremenyrepo.findAll());
        return "tabla";
    }

    @GetMapping("/kapcsolat")
    public String kapcsolat(Model m){
        m.addAttribute("uzenet" ,new UzenetekEntity());
        return "kapcsolat";
    }

    @PostMapping("/feldolgoz")
    public String feldolgoz(@ModelAttribute(name = "uzenet") UzenetekEntity uzenet, RedirectAttributes redirect, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "kapcsolat";
        }
        uzenetrepo.save(uzenet);
        redirect.addFlashAttribute("ertesites", "Üzenetét rögzítettük! Azonosítója: "+
                uzenet.getId());
        return "redirect:/kapcsolat";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public RedirectView hibasUzenet(ConstraintViolationException exception, RedirectAttributes attributes){
        attributes.addFlashAttribute("hiba","Legalább 10 karakter hosszú legyen az üzenet");
        return new RedirectView("/kapcsolat");
    }
}

