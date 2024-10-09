package com.gestionePersonale.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Credenziali {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Min(8)
    private String password;

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull @Min(8) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Min(8) String password) {
        this.password = password;
    }

    public boolean isAmministratore() {
        return email.contains("admin");
    }
}
