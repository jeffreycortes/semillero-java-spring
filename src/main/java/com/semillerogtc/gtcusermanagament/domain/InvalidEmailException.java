package com.semillerogtc.gtcusermanagament.domain;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("email no válido");
    }
}
