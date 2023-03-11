package com.semillerogtc.gtcusermanagament.infrastructure.controllers;

import com.semillerogtc.gtcusermanagament.common.EnvironmentService;
import net.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class QaEnvironmentService implements EnvironmentService {
    @Override
    public String getEnvironmentName() {
        return "ambiente qa";
    }

    @Override
    public String obtenerPoliticaDeClaveDeUsuario() {
        return "[0-9{1}A-ba-z]";
    }
}
