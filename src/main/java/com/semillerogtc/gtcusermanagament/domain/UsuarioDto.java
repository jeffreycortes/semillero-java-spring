package com.semillerogtc.gtcusermanagament.domain;

import lombok.Builder;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Builder
public class UsuarioDto {
    public String nombre;
    @NotEmpty
    public String email;
    @NotEmpty
    public int edad;
    public long celular;
    public Date fechaNacimiento;

}
