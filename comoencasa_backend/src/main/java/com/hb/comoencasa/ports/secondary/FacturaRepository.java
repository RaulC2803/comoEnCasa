package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
