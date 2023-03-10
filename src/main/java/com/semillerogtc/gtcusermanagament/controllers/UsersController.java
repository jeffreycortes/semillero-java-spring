package com.semillerogtc.gtcusermanagament.controllers;

import com.semillerogtc.gtcusermanagament.common.EnvironmentService;
import com.semillerogtc.gtcusermanagament.domain.UsuarioDto;
import com.semillerogtc.gtcusermanagament.domain.UsuarioDto2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.semillerogtc.gtcusermanagament.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.validation.Valid;

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
    public boolean consultarUsuarioPorQueryString(@RequestParam String email) {
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

    @PostMapping("v1/{token}")
    public ResponseEntity registrarUsuario(@PathVariable String input, @Valid @RequestBody UsuarioDto usuarioDto) throws Exception {
        logger.info(usuarioDto.email + "- " + usuarioDto.userId);
        var esRegistroExitoso = _user.registrarUsuario(input);
        if (!esRegistroExitoso)
            return new ResponseEntity("Falló la creación de usuario", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity("Usuario creado exitosamente", HttpStatus.CREATED);
    }

    @PostMapping("v2/{token}")
    public String registrarUsuario2(@Valid @RequestBody UsuarioDto2 usuarioDto) throws Exception {
        logger.info(usuarioDto.email + "- " + usuarioDto.userId);

        return "Hola desde método post 2";
    }

    @PatchMapping("/{id}")
    public boolean actualizarUsuario(@RequestBody UsuarioDto usuarioDto) {
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }

   @DeleteMapping("/{id}")
    public boolean eliminarUsuario() {
        String user = "Jeffrey";
        return _user.registrarUsuario(user);
    }
}