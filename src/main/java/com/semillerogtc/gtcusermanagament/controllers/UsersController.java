package com.semillerogtc.gtcusermanagament.controllers;

import com.semillerogtc.gtcusermanagament.common.EnvironmentService;
import com.semillerogtc.gtcusermanagament.domain.UsuarioDto;
import org.springframework.http.HttpHeaders;
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



    EnvironmentService _environmentService1;

    public final Logger logger = LoggerFactory.getLogger(UsersController.class);

    UsersController() {
    }

    @GetMapping("/ping")

    public String ping(
                @RequestHeader("Environment") String token
    ) {

        logger.info(token);
        return "Hola desde controlador usuarios";
    }


    @GetMapping
    public boolean consultarUsuarioPorHeader(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestHeader("") String userId) {
        logger.info(token + "- " + userId);
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }

    @GetMapping("/query")
    public boolean consultarUsuarioPorQueryStrings(@RequestParam String email) {
        logger.info(email);
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }

    @GetMapping("/uritemplate/{email}/{id}")
    public boolean consultarUsuarioPorPathOUriTemplate(@PathVariable("email")  String email, @PathVariable("id")  String userId) {
        logger.info(email + "- " + userId);
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }

    @PostMapping("/{token}")
    public boolean registrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        logger.info(usuarioDto.email + "- " + usuarioDto.userId);
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }

    @PatchMapping("/{id}")
    public boolean actualizarUsuario(@RequestBody UsuarioDto usuarioDto) {
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }

   @DeleteMapping
    public boolean eliminarUsuario() {
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }
}