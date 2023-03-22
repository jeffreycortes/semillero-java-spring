package com.semillerogtc.gtcusermanagament.aplication.services;


import com.semillerogtc.gtcusermanagament.domain.*;
import com.semillerogtc.gtcusermanagament.domain.components.PasswordEncoderService;
import org.springframework.stereotype.Service;
import com.semillerogtc.gtcusermanagament.domain.components.UsersValidation;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

@Service
public class UsersService {
    UsersValidation _usersValidation;
    UsuariosRepositorio usuariosRepositorio;
    PasswordEncoderService _passwordEncoderService;

    UsersService(
            UsersValidation usersValidation,
            UsuariosRepositorio usuariosRepositorio,
            PasswordEncoderService passwordEncoderService) {
        this.usuariosRepositorio = usuariosRepositorio;
        _usersValidation = usersValidation;
        this._passwordEncoderService = passwordEncoderService;
    }

    public Usuario registrarUsuario(UsuarioNuevoDto usuarioNuevoDto) {
        boolean resultado = _usersValidation.execute(usuarioNuevoDto);
        var pass = this.generarPassword();
        var passEncriptado1 = this._passwordEncoderService.encode(pass);
        var passEncriptado2 = this._passwordEncoderService.encode("otro");
        var esPasswordIgual = this._passwordEncoderService.validarPassword(pass, passEncriptado1);
        var esPassword2Igual = this._passwordEncoderService.validarPassword(pass, passEncriptado2);
        System.out.println(esPasswordIgual);

        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setName(usuarioNuevoDto.nombre);
        usuarioNuevo.setEmail(new Email(usuarioNuevoDto.email));
        usuarioNuevo.setEdad(usuarioNuevoDto.edad);

        UsuarioTelefono usuarioTelefono = new UsuarioTelefono();
        usuarioTelefono.setTelefono(usuarioNuevoDto.telefonos.get(0));
        Set<UsuarioTelefono> telefonosSet = new HashSet<UsuarioTelefono>();
        telefonosSet.add(usuarioTelefono);

        usuarioNuevo.setTelefonos(telefonosSet);

        var userRegistrado = this.usuariosRepositorio.save(usuarioNuevo);
        return userRegistrado;
    }

    public String generarPassword() {
        return "clavesegura";
    }

    public void elinminarUsuario(String userId) {
        this.usuariosRepositorio.deleteById(userId);
    }

    public Usuario consultarUsuarioXEmail(String email) {
        return this.usuariosRepositorio.findByEmail(new Email(email));
    }
}