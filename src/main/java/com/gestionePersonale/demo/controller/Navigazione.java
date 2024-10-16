package com.gestionePersonale.demo.controller;

import com.gestionePersonale.demo.model.Credenziali;
import com.gestionePersonale.demo.model.Personale;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Navigazione {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        model.addAttribute("utenteLoggato", utenteLoggato);
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(HttpSession session, Model model) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato != null) {
            return "redirect:/";
        }
        model.addAttribute("credenziali", new Credenziali());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("credenziali") Credenziali credenziali, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        session.setAttribute("utenteLoggato", credenziali);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/area_personale")
    public String areaPersonale(HttpSession session, Model model) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        model.addAttribute("utenteLoggato", utenteLoggato);
        if (utenteLoggato.isAmministratore()) {
            return "redirect:/area_amministratore";
        } else {
            return "redirect:/area_utente";
        }
    }

    @GetMapping("/area_utente")
    public String areaUtente(HttpSession session, Model model) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        model.addAttribute("utenteLoggato", utenteLoggato);
        if (utenteLoggato.isAmministratore()) {
            return "redirect:/area_amministratore";
        } else {
            return "area_utente";
        }
    }

    @GetMapping("/area_amministratore")
    public String areaAmministratore(HttpSession session, Model model) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        model.addAttribute("utenteLoggato", utenteLoggato);
        if (!utenteLoggato.isAmministratore()) {
            return "redirect:/area_utente";
        }

        model.addAttribute("personale", new Personale());
        return "area_amministratore";
    }

    @PostMapping("/areaAmministratore")
    public String processaFormAmministratore(@Valid @ModelAttribute("personale") Personale personale, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "area_amministratore";
        }

        return "redirect:/successo";
    }
}
