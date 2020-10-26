package com.hb.comoencasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hb.comoencasa.domain.Comprador;
import com.hb.comoencasa.domain.Factura;
import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.ports.primary.CompradorService;
import com.hb.comoencasa.ports.primary.ProductoService;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompradorServiceTest {
    private CompradorService compradorService;
    private ProductoService productoService;
    private Comprador comprador = new Comprador();
    private Factura factura = new Factura();
    private Producto producto = null;

    @Test
    public void validateAObtenerComprador() throws Exception{
        int id = 1;
        Long ID = Long.valueOf(id);
        Comprador comp;
        comp = compradorService.obtenerComprador(ID);

        assertNotNull(comp);
        // assertEquals(comprador.getName(), "Test");
        // assertEquals(comprador.getN_mobile(), "951671303");
        // assertEquals(comprador.getEmail(), "test@gmail.com");
        // assertEquals(comprador.getDni(), "71660908");
    }

    @Test
    public void validateBRegister() throws Exception {
        initComprador();

        Comprador registrado = compradorService.register(this.comprador);

        assertEquals(registrado.getIdComprador(), this.comprador.getIdComprador());
        assertEquals(registrado.getName(), this.comprador.getName());
        assertEquals(registrado.getLastName(), this.comprador.getLastName());
        assertEquals(registrado.getUsername(), this.comprador.getUsername());
        assertEquals(registrado.getEmail(), this.comprador.getEmail());
        assertEquals(registrado.getAddress(), this.comprador.getAddress());
    }

    @Test
    public void validateCListarFactura(){
        List<Factura> facturas = compradorService.listarFacturasComprador(this.comprador.getIdComprador());

        assertEquals(facturas.size(), 0);
    }

    @Test
    public void validateDRegistrarFactura() throws Exception { 
        initProducto();
        initFactura();

        this.compradorService.registrarFactura(this.factura, this.comprador.getIdComprador(), this.producto.getIdProducto());
    
        assertEquals(this.factura.getCantidad(), 5);
        assertEquals(this.factura.getComprador(), this.comprador);
        assertEquals(this.factura.getProducto(), this.producto);
        assertEquals(this.factura.getTotal(), 200);
    }


    private void initComprador(){
        this.comprador.setName("Pepe");
        this.comprador.setLastName("Fernandez");
        this.comprador.setUsername("Pepe01");
        this.comprador.setPassword("superpasswd");
        this.comprador.setAddress("Av. Palomar 123");
        this.comprador.setEmail("epep@gmail.com");
    }

    private void initProducto(){
        this.producto = this.productoService.obtenerProductoporId((long) 5);
    }

    private void initFactura(){
        this.factura.setCantidad(5);
        this.factura.setComprador(this.comprador);
        this.factura.setProducto(this.producto);
        this.factura.setTotal(200);
    }
}
