package com.semillerogtc.gtcusermanagament.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.semillerogtc.gtcusermanagament.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
@RequestMapping("/usuarios")
public class UsersController {
    @Autowired
    UsersService _user;
    public final Logger logger = LoggerFactory.getLogger(UsersController.class);

    UsersController() {
        logger.info("Se incializa constructor");
    }

    @GetMapping("/ping")
    public String ping() {
        return "Hola desde controlador usuarios";
    }

    @PostMapping()
    public boolean registrarUsuario() {
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }
}