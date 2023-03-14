package com.semillerogtc.gtcusermanagament.infrastructure.controllers;

import com.semillerogtc.gtcusermanagament.domain.UsuarioNuevoDto;
import com.semillerogtc.gtcusermanagament.infrastructure.environment.EnvironmentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.semillerogtc.gtcusermanagament.aplication.services.UsersService;
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
    public ResponseEntity consultarUsuarioPorHeader(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestHeader("") String userId) {
        logger.info(token + "- " + userId);
        UsuarioNuevoDto user = UsuarioNuevoDto.builder().email("Jeffrey").build();
        return new ResponseEntity(_user.registrarUsuario(user), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity consultarUsuarioPorQueryString(@RequestParam String email) {
        logger.info(email);
        UsuarioNuevoDto user = UsuarioNuevoDto.builder().email("Jeffrey").build();
        return new ResponseEntity(_user.registrarUsuario(user), HttpStatus.OK);
    }

    @GetMapping("/uritemplate/{email}/{id}")
    public ResponseEntity consultarUsuarioPorPathOUriTemplate(@PathVariable("email")  String email, @PathVariable("id")  String userId) {
        logger.info(email + "- " + userId);
        UsuarioNuevoDto user = UsuarioNuevoDto.builder().email("Jeffrey").build();
        return new ResponseEntity(_user.registrarUsuario(user), HttpStatus.OK);
    }

    @PostMapping("v1")
    public ResponseEntity registrarUsuario(@Valid @RequestBody UsuarioNuevoDto usuarioDto) {
        logger.info(usuarioDto.email);
        var usuarioRegistrado = _user.registrarUsuario(usuarioDto);

        return new ResponseEntity(usuarioRegistrado, HttpStatus.CREATED);
    }

    @PostMapping("v2/")
    public ResponseEntity registrarUsuario2(@Valid @RequestBody UsuarioNuevoDto usuarioDto) throws Exception {
        var usuarioRegistrado = _user.registrarUsuario(usuarioDto);

        return new ResponseEntity(usuarioRegistrado, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity actualizarUsuario(@RequestBody UsuarioNuevoDto usuarioDto) {
        UsuarioNuevoDto user = UsuarioNuevoDto.builder().email("Jeffrey").build();
        return new ResponseEntity(_user.registrarUsuario(user), HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable String id) {
        try{
            _user.elinminarUsuario(id);
            return new ResponseEntity("Usuario eliminado con éxito", HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NO_CONTENT);
        }
    }
}