package com.semillerogtc.gtcusermanagament.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuario, String> {
    Usuario findByEmail(Email email);
}
