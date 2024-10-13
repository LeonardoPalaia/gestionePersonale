package com.gestionePersonale.demo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Navigazione {
    private Credenziali utenteLoggato;

    @GetMapping("/")
    public String home(Model model) {
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        model.addAttribute("utenteLoggato", utenteLoggato);
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        if (utenteLoggato != null) {
            return "redirect:/";
        }
        model.addAttribute("credenziali", new Credenziali());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("credenziali") Credenziali credenziali, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        utenteLoggato = credenziali;
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        utenteLoggato = null;
        return "redirect:/";
    }

    @GetMapping("/area_personale")
    public String areaPersonale(Model model) {
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        model.addAttribute("utenteLoggato", utenteLoggato);
        if (utenteLoggato.isAmministratore()) {
            return "redirect:/area_amministratore";
        }
        else {
            return "redirect:/area_utente";
        }
    }

    @GetMapping("/area_utente")
    public String areaUtente() {
        return "area_utente";
    }

    @GetMapping("/area_amministratore")
    public String areaAmministartore() {
        return "area_amministratore";
    }
}
