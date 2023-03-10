package com.semillerogtc.gtcusermanagament.domain;

import javax.validation.constraints.NotEmpty;

public class UsuarioDto2 {
    @NotEmpty
    public String email;
    @NotEmpty
    public String userId;
    @NotEmpty
    public String celular;
}
