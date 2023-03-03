package com.semillerogtc.gtcusermanagament.common;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class DevEnvironmentService implements EnvironmentService {
    @Override
    public String getEnvironmentName() {
        return "dev";
    }

    @Override
    public String obtenerPoliticaDeClaveDeUsuario() {
        return "[0-9A-ba-z]";
    }
}
