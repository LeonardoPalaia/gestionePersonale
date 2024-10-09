package com.gestionePersonale.demo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class Navigazione {
    ArrayList<Personale> utentiLoggati = new ArrayList<>();

    @RequestMapping(value = "/areaUtente")
    public String areaUtente() {
        return "areaUtente";
    }

    @RequestMapping(value = "/areaAmministratore")
    public String areaAmministratore() {
        return "areaAmministratore";
    }
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String login(@Valid Personale personale, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "login";

        utentiLoggati.add(personale);
        return "redirect:/areaUtente";
    }
}
