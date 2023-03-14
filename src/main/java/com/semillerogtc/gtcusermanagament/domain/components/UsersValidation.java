package com.semillerogtc.gtcusermanagament.domain.components;

import com.semillerogtc.gtcusermanagament.domain.UsuarioNuevoDto;
import org.springframework.stereotype.Component;

@Component
public class UsersValidation {
    public boolean execute(UsuarioNuevoDto user) {
        return  user.email.equals("cortesj3f");
    }
}