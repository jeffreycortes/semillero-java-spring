package com.semillerogtc.gtcusermanagament.services;

import org.springframework.stereotype.Service;

import com.semillerogtc.gtcusermanagament.components.UsersValidation;


@Service
public class UsersService {
    UsersValidation _usersValidation;

    UsersService(UsersValidation usersValidation) {
        _usersValidation = usersValidation;
    }

    public boolean registrarUsuario(String user) {
        boolean resultado = _usersValidation.execute(user);
        return resultado;
    }

    public String consultarUsuario() {
        return "true";
    }
}