package com.hb.comoencasa;

import com.hb.comoencasa.domain.Factura;
import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.domain.Resena;
import com.hb.comoencasa.domain.Vendedor;
import com.hb.comoencasa.ports.primary.ProductoService;
import com.hb.comoencasa.ports.primary.VendedorService;

import io.jsonwebtoken.lang.Assert;
import org.junit.Test;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VendedorServiceTest {

    @Autowired()
    VendedorService vendedorService;

    @Autowired
    ProductoService productoService;

    @Test
    public void registrar() throws Exception {
        Vendedor vendedor= new Vendedor();
        vendedor.setUsername("xanderM");
        vendedor.setEmail("xandee@gmail.com");
        vendedor.setN_mobile("937347382");
        vendedor.setDni("71322244");
        vendedor.setLastname("Melendez");
        vendedor.setName("xander");
        vendedor.setDate("29/11/2020");
        vendedor.setAddress("Av. Grau");
        vendedor.setPassword("dsscnjcsS2");
        Vendedor v= vendedorService.registrar(vendedor);
        assertEquals(vendedor.getUsername(), v.getUsername());
        assertEquals(vendedor.getEmail(), v.getEmail());
        assertEquals(vendedor.getN_mobile(), v.getN_mobile());
        assertEquals(vendedor.getDni(), v.getDni());
        assertEquals(vendedor.getLastname(), v.getLastname());
        assertEquals(vendedor.getName(), v.getName());
        assertEquals(vendedor.getDate(), v.getDate());
        assertEquals(vendedor.getPassword(), v.getPassword());
    }
    @Test(expected = Exception.class)
    public void registrarFallido()throws Exception{
        Vendedor vendedor = null;
        Vendedor v= vendedorService.registrar(vendedor);
    }

    @Test
    public void obtenerVendedor() throws Exception {
        Vendedor vendedor= vendedorService.obtenerVendedor((long)1);
        assertNotNull(vendedor.getIdVendedor());
    }

    @Test (expected = Exception.class)
    public void obtenerVendedorFallido() throws Exception {
        Vendedor vendedor= vendedorService.obtenerVendedor((long)1000);
        assertNull(vendedor.getIdVendedor());
    }

    @Test
    public void registrarProducto() throws  Exception {
        Producto producto =new Producto();
        producto.setDescription("Bonito");
        producto.setName("Mando");
        producto.setPrice(5);
        producto.setTags("Videojuegos");
        producto.setCategoria("Games");
        producto.setStock(8);
        Producto p= vendedorService.registrarProducto(producto,(long)1);
        assertEquals(producto.getDescription(),p.getDescription());
        assertEquals(producto.getName(),p.getName());
        assertEquals(producto.getPrice(),p.getPrice());
        assertEquals(producto.getTags(),p.getTags());
        assertEquals(producto.getCategoria(),p.getCategoria());
        assertEquals(producto.getStock(),p.getStock());

    }
    @Test (expected = Exception.class)
    public void registrarProductoFallido() throws  Exception {
        Producto producto =null;
        Producto p= vendedorService.registrarProducto(producto,(long)1);
    }
    @Test
    public void obtenerPporVendedor() {
       List<Producto> productos=vendedorService.obtenerPporVendedor((long)1);
       Assert.notEmpty(productos);
    }

    @Test
    public void obtenerFporVendedor() {
        List<Factura> facturas=vendedorService.obtenerFporVendedor((long)1);
        Assert.notEmpty(facturas);
    }
    @Test
    public void obtenerRporVendedor(){
        List<Resena> resenas=vendedorService.obtenerRporVendedor((long)1);
        Assert.notEmpty(resenas);
    }

}

/*
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendedorServiceTest {

    @MockBean
    VendedorRepository vendedorRepository;

    @Autowired()
    VendedorService vendedorService;

    @Autowired
    ProductoService productoService;

    @Test
    void validateZRegistrar() throws Exception {


    }

    @Test
    public void validateAObtenerVendedor() throws Exception {
        Long vendedorId=334325423554L;
        Vendedor vendedor = new Vendedor() ;

        Optional<Vendedor> vendedorOptional = Optional.of(vendedor);
        when(vendedorRepository.findById(vendedorId)).thenReturn(vendedorOptional);
        //Cuando
        Vendedor v=vendedorService.obtenerVendedor(vendedorId);
        assertNotNull(v);
    }

    @Test
    void validateZRegistrarProducto() {

    }

    @Test
    void validateBObtenerPporVendedor() {

        Long vendedorID=324L;
        Vendedor vendedor=new Vendedor();

        Optional<Vendedor> vendedorOptional = Optional.of(vendedor);
        when(vendedorRepository.findById(vendedorID)).thenReturn(vendedorOptional);

        List<Producto> productos1=productoService.obtenerPorVendedor(vendedorID);
        //Entonces se mostrarán todos los productos que se hayan guardado
        assertNotNull(productos1);
    }

    @Test
    void validateCObtenerFporVendedor() {
        Long vendedorID=324L;
        Vendedor vendedor=new Vendedor();

        Optional<Vendedor> vendedorOptional = Optional.of(vendedor);
        when(vendedorRepository.findById(vendedorID)).thenReturn(vendedorOptional);

        List<Factura> v=vendedorService.obtenerFporVendedor(vendedorID);
        //Entonces se mostrarán todos los pro ductos que se hayan guardado
        assertNotNull(v);
    }
}*/