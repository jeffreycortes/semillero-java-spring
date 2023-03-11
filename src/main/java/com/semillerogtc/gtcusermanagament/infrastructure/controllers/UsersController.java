package com.semillerogtc.gtcusermanagament.infrastructure.controllers;

import com.semillerogtc.gtcusermanagament.common.EnvironmentService;
import com.semillerogtc.gtcusermanagament.domain.UsuarioDto;
import com.semillerogtc.gtcusermanagament.domain.UsuarioDto2;
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
        UsuarioDto user = UsuarioDto.builder().email("Jeffrey").build();
        return new ResponseEntity(_user.registrarUsuario(user), HttpStatus.OK);
    }

    @GetMapping("/query")
    public ResponseEntity consultarUsuarioPorQueryString(@RequestParam String email) {
        logger.info(email);
        UsuarioDto user = UsuarioDto.builder().email("Jeffrey").build();
        return new ResponseEntity(_user.registrarUsuario(user), HttpStatus.OK);
    }

    @GetMapping("/uritemplate/{email}/{id}")
    public ResponseEntity consultarUsuarioPorPathOUriTemplate(@PathVariable("email")  String email, @PathVariable("id")  String userId) {
        logger.info(email + "- " + userId);
        UsuarioDto user = UsuarioDto.builder().email("Jeffrey").build();
        return new ResponseEntity(_user.registrarUsuario(user), HttpStatus.OK);
    }

    @PostMapping("v1")
    public ResponseEntity registrarUsuario(@RequestBody UsuarioDto usuarioDto) throws Exception {
        logger.info(usuarioDto.email + "- " + usuarioDto.celular);
        try{
            var usuarioRegistrado = _user.registrarUsuario(usuarioDto);

            return new ResponseEntity(usuarioRegistrado, HttpStatus.CREATED);
        } catch(Exception ex) {
            return new ResponseEntity("Falló la creación de usuario, Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("v2/")
    public ResponseEntity registrarUsuario2(@Valid @RequestBody UsuarioDto usuarioDto) throws Exception {
        var usuarioRegistrado = _user.registrarUsuario(usuarioDto);

        return new ResponseEntity(usuarioRegistrado, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity actualizarUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto user = UsuarioDto.builder().email("Jeffrey").build();
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