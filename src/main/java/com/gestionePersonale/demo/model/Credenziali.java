package com.gestionePersonale.demo.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public class Credenziali {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 8, message = "La password deve essere almeno di 8 caratteri")
    private String password;

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull @Size(min = 8, message = "La password deve essere almeno di 8 caratteri") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 8, message = "La password deve essere almeno di 8 caratteri") String password) {
        this.password = password;
    }

    public boolean isAmministratore() {
        return email.contains("admin");
    }
}
