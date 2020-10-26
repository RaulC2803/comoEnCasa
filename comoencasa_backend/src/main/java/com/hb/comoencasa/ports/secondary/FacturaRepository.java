package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("select f from Factura f where f.comprador.idComprador = :id")
    public List<Factura>  facturasComprador (@Param("id")Long Id);

    @Query("select f from Factura f where f.producto.vendedor.idVendedor = :id")
    public List<Factura>  facturasVendedor (@Param("id")Long Id);
}
