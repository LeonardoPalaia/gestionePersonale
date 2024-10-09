package com.gestionePersonale.demo;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class Navigazione {

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        // Aggiungiamo l'oggetto Credenziali al model solo se esiste in sessione
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato != null) {
            model.addAttribute("utenteLoggato", utenteLoggato);
        }
        return "index";
    }


    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("credenziali", new Credenziali());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("credenziali") @Valid Credenziali credenziali,
                        BindingResult bindingResult,
                        HttpSession session,
                        Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        // Esempio di validazione: verifica email e password con il database
        // Se l'autenticazione ha successo:
        session.setAttribute("utenteLoggato", credenziali);

        if (credenziali.isAmministratore()) {
            return "redirect:/areaAmministratore";
        }
        return "redirect:/areaUtente";
    }


    @GetMapping("/areaUtente")
    public String areaUtente(HttpSession session) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        return "areaUtente";
    }

    @GetMapping("/areaAmministratore")
    public String areaAmministratore(HttpSession session) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null || !utenteLoggato.isAmministratore()) {
            return "redirect:/login";
        }
        return "areaAmministratore";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}