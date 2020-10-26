package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Factura;
import com.hb.comoencasa.domain.Lista_Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListaProductoRepository extends JpaRepository<Lista_Producto, Long> {
    @Query("select p from Lista_Producto p where p.comprador.idComprador = :id")
    public List<Lista_Producto> productosComprador (@Param("id")Long Id);
}
