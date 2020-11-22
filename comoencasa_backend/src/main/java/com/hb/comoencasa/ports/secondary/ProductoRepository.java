package com.hb.comoencasa.ports.secondary;

import com.hb.comoencasa.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query ("select p from Producto p where p.name like %?1% or p.tags like %?1% or p.description like %?1% or p.categoria like %?1%")
    public List<Producto> buscar (String name);

    @Query ("select p from Producto p where p.price between ?1 and ?2")
    public  List<Producto> filtrarPorPrecio (Double low, Double high);

    @Query ("select p from Producto p where p.vendedor.idVendedor = :id")
    public List<Producto> productosVendedor (@Param("id")Long Id);

    @Query ("select p from Producto p where p.categoria= :id")
    public List<Producto> productosPorCategoria(@Param("id")String nCategoria );

}
