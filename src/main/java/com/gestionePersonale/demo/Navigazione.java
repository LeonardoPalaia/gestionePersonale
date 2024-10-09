package com.gestionePersonale.demo;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes("utenteLoggato")
public class Navigazione {
    ArrayList<Personale> utentiLoggati = new ArrayList<>();

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
    /*@PostMapping("login")
    public String login(@Valid Credenziali credenziali, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors())
            return "login";

        model.addAttribute("loggedInUser", credenziali);
        return "redirect:/areaUtente";
    }*/

    @PostMapping("/login")
    public String login(@Valid Credenziali credenziali, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        // Qui dovresti aggiungere la logica per verificare le credenziali
        // dell'utente nel database. Per ora simuliamo un login successful

        session.setAttribute("loggedInUser", credenziali);

        if (credenziali.isAmministratore()) {
            return "redirect:/areaAmministratore";
        }
        return "redirect:/areaUtente";
    }

    @PostMapping("areaAmministratore")
    public String areaAmministratore(@Valid Personale personale, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "areaAmministratore";

        //utentiSalvati.add(personale);

        return "redirect:/areaAmministratore";
    }

}
