package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Comprador, Long>{

}
