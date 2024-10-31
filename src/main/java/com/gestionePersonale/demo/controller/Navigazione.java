package com.gestionePersonale.demo.controller;

import com.gestionePersonale.demo.Dao.OrarioLavoroDao;
import com.gestionePersonale.demo.Dao.PersonaleDao;
import com.gestionePersonale.demo.Dao.RuoloDao;
import com.gestionePersonale.demo.model.Credenziali;
import com.gestionePersonale.demo.model.OrarioLavoro;
import com.gestionePersonale.demo.model.Personale;
import com.gestionePersonale.demo.model.Ruolo;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Navigazione {

    private final PersonaleDao personaleDao;
    private final RuoloDao ruoloDao;
    private final OrarioLavoroDao orarioLavoroDao;

    public Navigazione(PersonaleDao personaleDao, RuoloDao ruoloDao, OrarioLavoroDao orarioLavoroDao) {
        this.personaleDao = personaleDao;
        this.ruoloDao = ruoloDao;
        this.orarioLavoroDao = orarioLavoroDao;
    }

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
        Personale utente = personaleDao.findByEmail(credenziali.getEmail());
        if (utente == null || !utente.getPassword().equals(credenziali.getPassword())) {
            return "login";
        }
        session.setAttribute("utenteLoggato", utente);
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
        return utenteLoggato.isAmministratore() ? "redirect:/area_amministratore" : "redirect:/area_utente";
    }

    @GetMapping("/area_utente")
    public String areaUtente(HttpSession session, Model model) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login"; // Reindirizza se l'utente non è loggato
        }

        model.addAttribute("utenteLoggato", utenteLoggato);

        Personale personale = personaleDao.findByEmail(utenteLoggato.getEmail());
        if (personale != null) {
            List<OrarioLavoro> orari = orarioLavoroDao.findByPersonaleId(personale.getId());
            model.addAttribute("orari", orari);
        }

        return "area_utente";
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
        List<Ruolo> ruoli = ruoloDao.findAll();
        model.addAttribute("ruoli", ruoli);

        return "area_amministratore";
    }

    @PostMapping("/areaAmministratore")
    public String processaFormAmministratore(@Valid @ModelAttribute("personale") Personale personale, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ruoli", ruoloDao.findAll());
            return "area_amministratore";
        }

        // Assegna ruolo usando oggetto Ruolo
        Ruolo ruolo = personale.getRuolo();
        if (ruolo != null) {
            personale.setRuolo(ruolo);
            personaleDao.save(personale);
        }

        return "redirect:/successo";
    }

    @GetMapping("/successo")
    public String successo(HttpSession session, Model model) {
        Credenziali utenteLoggato = (Credenziali) session.getAttribute("utenteLoggato");
        if (utenteLoggato == null) {
            return "redirect:/login";
        }
        model.addAttribute("utenteLoggato", utenteLoggato);
        return "successo";
    }
}
