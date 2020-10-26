package com.hb.comoencasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        Comprador comp = new Comprador();
        comp.setName("Pipe");
        comp.setLastName("Hernandez");
        comp.setUsername("Qepe01");
        comp.setPassword("sudperpasswd");
        comp.setAddress("Av. dPalomar 123");
        comp.setEmail("epp@gmail.com");
        
        Comprador registrado = compradorService.register(comp);

        assertEquals(registrado.getIdComprador(), comp.getIdComprador());
        assertEquals(registrado.getName(), comp.getName());
        assertEquals(registrado.getLastName(), comp.getLastName());
        assertEquals(registrado.getUsername(), comp.getUsername());
        assertEquals(registrado.getEmail(), comp.getEmail());
        assertEquals(registrado.getAddress(), comp.getAddress());
    }
    
    @Test
    public void validateBRegisterFallido() throws Exception {
        Comprador comp = new Comprador();
        comp.setName("Fallo");
        comp.setLastName("Catastrofico");
        comp.setUsername("Fallo01");
        comp.setPassword("sudperpasswd");
        comp.setAddress("Av. dPalomar 123");
        
        Comprador registrado = compradorService.register(comp);

        assertNotNull(registrado.getIdComprador());
        assertNotNull(registrado.getName());
        assertNotNull(registrado.getLastName());
        assertNotNull(registrado.getUsername());
        assertNull(registrado.getEmail());
        assertNull(registrado.getDni());
        assertNotNull(registrado.getAddress());
    }

    @Test
    public void validateCListarFactura() throws Exception {
        List<Factura> facturas = compradorService.listarFacturasComprador((long) 1);

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
}
