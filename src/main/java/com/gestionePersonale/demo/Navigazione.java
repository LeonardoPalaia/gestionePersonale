package com.gestionePersonale.demo;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("utenteLoggato")
public class Navigazione {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid Credenziali credenziali, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        // Validazione utente con DB
        session.setAttribute("utenteLoggato", credenziali);
        if (credenziali.isAmministratore()) {
            return "redirect:/areaAmministratore";
        }
        return "redirect:/areaUtente";
    }

    @GetMapping("/areaUtente")
    public String areaUtente() {
        return "areaUtente";
    }

    @GetMapping(value = "/areaAmministratore")
    public String areaAmministratore() {
        return "areaAmministratore";
    }

    @PostMapping("areaAmministratore")
    public String areaAmministratore(@Valid Personale personale, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "areaAmministratore";

        return "redirect:/areaAmministratore";
    }
}
