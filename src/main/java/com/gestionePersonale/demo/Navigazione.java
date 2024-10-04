package com.gestionePersonale.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Navigazione {
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

    @RequestMapping(value = "/registrazione")
    public String registrazione() {
        return "registrazione";
    }

}
