package com.semillerogtc.gtcusermanagament.domain;

import javax.validation.constraints.NotEmpty;

public class UsuarioDto {
    @NotEmpty
    public String email;
    @NotEmpty
    public String userId;
}
