package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.domain.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResenaRepository extends JpaRepository<Resena, Long> {
    @Query("select r from Resena r where r.producto.vendedor.idVendedor = :id")
    public List<Resena> resenasVendedor (@Param("id")Long Id);

    @Query("select r from Resena r where r.comprador.idComprador = :id")
    public List<Resena> resenasComprador (@Param("id")Long Id);
}
