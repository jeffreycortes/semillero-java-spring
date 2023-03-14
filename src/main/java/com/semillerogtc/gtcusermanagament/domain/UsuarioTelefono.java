package com.semillerogtc.gtcusermanagament.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="usuarios_telefonos")
public class UsuarioTelefono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = TelefonoAttributeConverter.class)
    private Telefono telefono;

    public String getTelefono() {
        return telefono.getValue();
    }

    public void setTelefono(String telefono) {
        this.telefono = new Telefono(telefono);
    }
}
