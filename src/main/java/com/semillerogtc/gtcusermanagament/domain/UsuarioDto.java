package com.semillerogtc.gtcusermanagament.domain;

import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Builder
public class UsuarioDto {
    @NotEmpty(message = "Nombre es obligatorio")
    public String nombre;
    @NotEmpty(message = "Email es obligatorio")
    public String email;
    public int edad;
    public long celular;
    public Date fechaNacimiento;

}
