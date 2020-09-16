package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
