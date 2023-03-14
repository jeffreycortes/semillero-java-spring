package com.semillerogtc.gtcusermanagament.aplication.services;


import com.semillerogtc.gtcusermanagament.domain.Telefonos;
import com.semillerogtc.gtcusermanagament.domain.UsuarioNuevoDto;
import org.springframework.stereotype.Service;
import com.semillerogtc.gtcusermanagament.domain.Usuario;
import com.semillerogtc.gtcusermanagament.domain.UsuariosRepositorio;
import com.semillerogtc.gtcusermanagament.domain.components.UsersValidation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        usuarioNuevo.setEmail(usuarioNuevoDto.email);
        usuarioNuevo.setEdad(usuarioNuevoDto.edad);

        Telefonos telefono1 = new Telefonos();
        telefono1.setTelefono(usuarioNuevoDto.telefonos.get(0));
        Set<Telefonos> telefonosSet = new HashSet<Telefonos>();
        telefonosSet.add(telefono1);

        usuarioNuevo.setTelefonos(telefonosSet);

        var userRegistrado = this.usuariosRepositorio.save(usuarioNuevo);
        return userRegistrado;
    }

    public void elinminarUsuario(String userId) {
        this.usuariosRepositorio.deleteById(userId);
    }

    public String consultarUsuario() {
        return "true";
    }
}