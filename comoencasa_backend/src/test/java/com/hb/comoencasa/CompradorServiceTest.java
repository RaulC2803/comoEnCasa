package com.hb.comoencasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.hb.comoencasa.domain.*;
import com.hb.comoencasa.ports.primary.CompradorService;
import com.hb.comoencasa.ports.primary.ProductoService;

import io.jsonwebtoken.lang.Assert;
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
        comp.setUsername("die3321uguito22");
        comp.setPassword("sudperpasswd");
        comp.setAddress("Av. dPalomar 123");
        comp.setEmail("baz42t3n34@gmail.com");

        Comprador registrado = compradorService.register(comp);

        assertEquals(registrado.getIdComprador(), comp.getIdComprador());
        assertEquals(registrado.getName(), comp.getName());
        assertEquals(registrado.getLastName(), comp.getLastName());
        assertEquals(registrado.getUsername(), comp.getUsername());
        assertEquals(registrado.getEmail(), comp.getEmail());
        assertEquals(registrado.getAddress(), comp.getAddress());
    }

    @Test (expected = Exception.class)
    public void validateBRegisterFallido() throws Exception {
        Comprador comp = null;
        Comprador registrado = compradorService.register(comp);
        assertNotNull(registrado.getIdComprador());

    }

    @Test
    public void validateCListarFactura() throws Exception {
        List<Factura> facturas = compradorService.listarFacturasComprador((long) 2);

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
        factura.setEnvio(2);
        Factura registro = compradorService.registrarFactura(factura, comp.getIdComprador(), prod.getIdProducto());

        assertNotNull(registro);
        assertEquals(registro.getCantidad(), factura.getCantidad());
        assertEquals(registro.getComprador().getIdComprador(), comp.getIdComprador());
        assertEquals(registro.getProducto().getIdProducto(), prod.getIdProducto());
        assertEquals(registro.getTotal(), factura.getTotal());
    }

    @Test(expected = Exception.class)
    public void validateDRegistrarFacturaFallida() throws Exception {
        //initProducto();
        // this.producto = this.productoService.obtenerProductoporId((long) 2);
        Comprador comp = null;
        Producto prod = null;

        Factura factura =  null;
        Factura registro = compradorService.registrarFactura(factura, comp.getIdComprador(), prod.getIdProducto());
        assertNotNull(registro.getIdFactura());
    }

    @Test
    public void listarProductosCompradorTest() throws Exception{
        List <Lista_Producto> listproducto=compradorService.listarProductosComprador((long)5);
        Assert.notEmpty(listproducto);
    }

    @Test
    public void eliminarProductosListaTest() throws Exception{
        Lista_Producto producto =compradorService.eliminarProductoLista((long) 15);
        Assert.notNull(producto.getCodigo());
    }
    @Test (expected = Exception.class)
    public void eliminarProductosListaTestFallido() throws Exception{
        Lista_Producto producto =compradorService.eliminarProductoLista((long) 600);
        Assert.notNull(producto.getCodigo());
    }
    @Test
    public void anadirResenaTest() throws Exception{

        Resena resena= new Resena();
        resena.setComentary("Bien fresco el pana");
        resena.setDate("06/11/2020");
        resena.setStars(5);
        Resena c= compradorService.anadirResena(resena,(long)1,(long)5);
        assertNotNull(c.getComentary());
        assertNotNull(c.getDate());
        assertNotNull(c.getStars());
    }
    @Test (expected = Exception.class)
    public void anadirResenaTestException() throws Exception{

        Resena resena= null;
        resena.setComentary("Bien fresco el pana");
        resena.setDate("06/11/2020");
        resena.setStars(5);
        Resena c= compradorService.anadirResena(resena,(long)1,(long)5);

    }


    @Test
    public void listarResenaTest() throws Exception{
        List<Resena> listresena= compradorService.listarResenas((long)5);
        Assert.notEmpty(listresena);
    }

    @Test
    public void anadirProductoTest() throws  Exception{
        Lista_Producto listproduct=new Lista_Producto();
        listproduct.setCantidad(3);
        Lista_Producto l=compradorService.anadirProducto(listproduct,(long)1, (long)7);
        assertNotNull(l.getCantidad());
    }
    @Test(expected = Exception.class)
    public void anadirProductoTestFallido() throws  Exception{
        Lista_Producto listproduct=null;
        Lista_Producto l=compradorService.anadirProducto(listproduct,(long)1, (long)7);
        assertNull(l.getCantidad());
    }
}