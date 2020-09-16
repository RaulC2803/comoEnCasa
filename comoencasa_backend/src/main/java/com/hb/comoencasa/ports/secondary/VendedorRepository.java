package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
