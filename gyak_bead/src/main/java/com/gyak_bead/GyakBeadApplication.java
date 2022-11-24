package com.gyak_bead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
    public String Nyitp(){
        return "nyito";
    }

    @GetMapping("/adatbazis")
    public String Adatbazis(Model model){
        model.addAttribute("huzasok",huzasrepo.findAll());
        model.addAttribute("huzottak",huzottrepo.findAll());
        model.addAttribute("nyeremenyek",nyeremenyrepo.findAll());

        return "tabla";}
    @GetMapping("kapcsolat")
    public String Kapcsolat(Model m){
        m.addAttribute(new UzenetekEntity());
        return "kapcsolat";
    }
    @PostMapping("/feldolgoz")
    public String Feldolgoz(@ModelAttribute UzenetekEntity uzenet, RedirectAttributes redirect) {
        /*for(UzenetekEntity u : uzenetrepo.findAll()){
            if(u.getTartalom().equals(uzenet.getTartalom()) && u.getId()== uzenet.getId())
                redirAttr.addFlashAttribute("hiba","Van már ilyen üzenet rögzítve:\n"+uzenet.getTartalom());
            return "redirect:/kapcsolat";
        }*/
        for (UzenetekEntity uzenet2 : uzenetrepo.findAll())
            if (uzenet2.getId() == (uzenet.getId()) && uzenet2.getTartalom().equals(uzenet.getTartalom())) {
                redirect.addFlashAttribute("uzenet", "Már van ilyen.");

                return "kapcsolat";
            }
        uzenetrepo.save(uzenet);
        redirect.addFlashAttribute("uzenet", "Új üzenet hozzá lett adva!");
        return "nyito";
    }

    /*
    @GetMapping("/oke")
    public String oke(@ModelAttribute(name="uj") UzenetekEntity uz){
        return "kapcsolatfeldolg";
    }
     */


}

