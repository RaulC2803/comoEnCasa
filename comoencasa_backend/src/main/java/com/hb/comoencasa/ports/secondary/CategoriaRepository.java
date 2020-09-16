package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
