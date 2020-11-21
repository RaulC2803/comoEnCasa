package com.hb.comoencasa;
import com.hb.comoencasa.adapters.primary.ProductoRest;
import com.hb.comoencasa.domain.Producto;
import io.jsonwebtoken.lang.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductoRestTest {

    @Autowired
    private ProductoRest productoRest;

    @Test
    public void listProducts (){
        List<Producto> response = productoRest.listar();
        Assert.notEmpty(response);
    }
    @Test
    public void obtenerPorVendedor() {
        List<Producto> producto = productoRest.obtenerPorVendedor((long) 1);
        Assert.notEmpty(producto);
    }

    @Test
    public void obtenerPorID(){
        Producto producto=productoRest.obtenerProducto((long)2);
        assertNotNull(producto);
        assertEquals(producto.getName(),"CocaCola");
    }
    @Test
    public void actualizarProducto() throws Exception{
        Producto producto=new Producto();
        producto.setName("InkaCola");
        producto.setPrice(3.0);
        producto.setDescription("Bebida gasificada");
        producto.setTags("Gaseosa Bebida");
        producto.setStock(5);
        Producto p=productoRest.actualizarProducto((long)3,producto);

        assertEquals(p.getPrice(),3.0,.1);
        assertEquals(p.getName(),"InkaCola");
        assertEquals(p.getDescription(),"Bebida gasificada");
        assertEquals(p.getTags(),"Gaseosa Bebida");
        assertEquals(p.getStock(),5,.1);
    }
    @Test
    public void buscarPorNombre(){
        List <Producto> producto=productoRest.buscarPorNombre("Bebida");
        Assert.notEmpty(producto);
    }
    @Test
    public void filtrarPrecio() {

        List<Producto> producto=productoRest.filtrarPrecio(2.0,10.0);
        Assert.notEmpty(producto);
    }
    @Test
    public void actualizarStock() throws  Exception{
        Producto producto=new Producto();
        producto.setStock(5);
        Producto p= productoRest.actualizarStock((long)2,producto);
        assertEquals(p.getStock(),5,.1);
    }
}
