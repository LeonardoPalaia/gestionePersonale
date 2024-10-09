package com.gestionePersonale.demo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes("utenteLoggato")
public class Navigazione {

    @GetMapping(value = "/areaUtente")
    public String areaUtente() {
        return "areaUtente";
    }
    @GetMapping(value = "/areaAmministratore")
    public String areaAmministratore() {
        return "areaAmministratore";
    }
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
    @PostMapping("login")
    public String login(@Valid Personale personale, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors())
            return "login";

        model.addAttribute("loggedInUser", personale);
        return "redirect:/areaUtente";
    }
}
