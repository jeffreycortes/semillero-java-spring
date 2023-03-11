package com.semillerogtc.gtcusermanagament.domain.components;

import com.semillerogtc.gtcusermanagament.domain.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public class UsersValidation {
    public boolean execute(UsuarioDto user) {
        return  user.email.equals("cortesj3f");
    }
}