package com.semillerogtc.gtcusermanagament.domain;

import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Builder
public class UsuarioNuevoDto {
    @NotEmpty(message = "Nombre es obligatorio")
    public String nombre;
    @NotEmpty(message = "Email es obligatorio")
    public String email;
    public int edad;
    public List<String> telefonos;
}
