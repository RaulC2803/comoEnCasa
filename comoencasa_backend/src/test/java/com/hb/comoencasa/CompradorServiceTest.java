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
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompradorServiceTest {
    @Autowired
    private CompradorService compradorService;
    @Autowired
    private ProductoService productoService;

    private Comprador comprador = new Comprador();

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
        //initProducto();
        // this.producto = this.productoService.obtenerProductoporId((long) 2);
        Comprador comp = compradorService.obtenerComprador((long)1);
        Producto prod = productoService.obtenerProductoporId((long)7);

        Factura factura =  new Factura();
        factura.setCantidad(5);
        factura.setComprador(comp);
        factura.setProducto(prod);
        factura.setTotal(250);

        Factura registro = compradorService.registrarFactura(factura, comp.getIdComprador(), prod.getIdProducto());

        assertNotNull(registro);
        assertEquals(registro.getCantidad(), factura.getCantidad());
        assertEquals(registro.getComprador().getIdComprador(), comp.getIdComprador());
        assertEquals(registro.getProducto().getIdProducto(), prod.getIdProducto());
        assertEquals(registro.getTotal(), factura.getTotal());
    }


    private void initComprador(){
        this.comprador.setName("Pipe");
        this.comprador.setLastName("Hernandez");
        this.comprador.setUsername("Qepe01");
        this.comprador.setPassword("sudperpasswd");
        this.comprador.setAddress("Av. dPalomar 123");
        this.comprador.setEmail("epp@gmail.com");
    }
}
