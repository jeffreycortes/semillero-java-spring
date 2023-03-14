package com.semillerogtc.gtcusermanagament.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @NotEmpty(message = "El nombre es obligatorio")
    private String name;
    @Convert(converter = EmailAttributeConverter.class)
    private Email email;
    private Integer edad;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    Set<UsuarioTelefono> telefonos;
}