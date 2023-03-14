package com.semillerogtc.gtcusermanagament.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="usuarios_telefonos")
public class Telefonos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String telefono;

    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
