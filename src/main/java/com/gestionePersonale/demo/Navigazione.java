package com.gestionePersonale.demo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class Navigazione {
    private boolean isLoggedIn = false;
    @GetMapping("/index")
    public String index() {
        if(isLoggedIn) {
            return "index";
        }
        else return "login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid Credenziali credenziali, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        // Validazione con il DB
        isLoggedIn = true;
        return "redirect:/index";
    }
}