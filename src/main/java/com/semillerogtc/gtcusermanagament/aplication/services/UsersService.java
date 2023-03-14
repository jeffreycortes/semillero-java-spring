package com.semillerogtc.gtcusermanagament.aplication.services;


import com.semillerogtc.gtcusermanagament.domain.*;
import org.springframework.stereotype.Service;
import com.semillerogtc.gtcusermanagament.domain.components.UsersValidation;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsersService {
    UsersValidation _usersValidation;
    UsuariosRepositorio usuariosRepositorio;

    UsersService(
            UsersValidation usersValidation,
            UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
        _usersValidation = usersValidation;
    }

    public Usuario registrarUsuario(UsuarioNuevoDto usuarioNuevoDto) {
        boolean resultado = _usersValidation.execute(usuarioNuevoDto);

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

    public void elinminarUsuario(String userId) {
        this.usuariosRepositorio.deleteById(userId);
    }

    public Usuario consultarUsuarioXEmail(String email) {
        return this.usuariosRepositorio.findByEmail(new Email(email));
    }
}