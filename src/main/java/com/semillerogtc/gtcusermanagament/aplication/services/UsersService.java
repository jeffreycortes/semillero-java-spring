package com.semillerogtc.gtcusermanagament.aplication.services;


import com.semillerogtc.gtcusermanagament.domain.UsuarioDto;
import org.springframework.stereotype.Service;
import com.semillerogtc.gtcusermanagament.domain.Usuario;
import com.semillerogtc.gtcusermanagament.domain.UsuariosRepositorio;
import com.semillerogtc.gtcusermanagament.domain.components.UsersValidation;

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

    public Usuario registrarUsuario(UsuarioDto usuarioDto) {
        boolean resultado = _usersValidation.execute(usuarioDto);

        Usuario usuarioARegistar = new Usuario();
        usuarioARegistar.setEmail(usuarioDto.email);
        usuarioARegistar.setEdad(usuarioDto.edad);
        usuarioARegistar.setCelular(usuarioDto.celular);
        usuarioARegistar.setName(usuarioDto.nombre);


        var userRegistrado = this.usuariosRepositorio.save(usuarioARegistar);
        return userRegistrado;
    }

    public void elinminarUsuario(String userId) {
        this.usuariosRepositorio.deleteById(userId);
    }

    public String consultarUsuario() {
        return "true";
    }
}