package com.semillerogtc.gtcusermanagament.infrastructure.environment;

import org.springframework.beans.factory.annotation.Value;

public interface EnvironmentService {
    String obtenerPoliticaDeClaveDeUsuario();
    String getEnvironmentName();
}
