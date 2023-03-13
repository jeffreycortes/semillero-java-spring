package com.semillerogtc.gtcusermanagament.infrastructure.environment;

import com.semillerogtc.gtcusermanagament.infrastructure.environment.EnvironmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
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
