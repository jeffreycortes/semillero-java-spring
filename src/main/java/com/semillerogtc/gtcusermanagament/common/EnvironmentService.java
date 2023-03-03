package com.semillerogtc.gtcusermanagament.common;

import org.springframework.beans.factory.annotation.Value;

public interface EnvironmentService {
    String obtenerPoliticaDeClaveDeUsuario();
    String getEnvironmentName();
}
