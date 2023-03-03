package com.semillerogtc.gtcusermanagament.controllers;

import com.semillerogtc.gtcusermanagament.common.EnvironmentService;
import org.springframework.beans.factory.annotation.Qualifier;
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
    EnvironmentService _environmentService;

    public final Logger logger = LoggerFactory.getLogger(UsersController.class);

    UsersController(@Qualifier("devEnvironmentService") EnvironmentService environmentService) {
        _environmentService = environmentService;
        logger.info("Se incializa constructor");
        logger.info("Ambiente configurado: " + _environmentService.getEnvironmentName());
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