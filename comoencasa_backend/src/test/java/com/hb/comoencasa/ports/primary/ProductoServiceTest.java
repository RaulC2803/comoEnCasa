package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.ports.secondary.VendedorRepository;
import io.jsonwebtoken.lang.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductoServiceTest {

    @Autowired
    private ProductoService productoService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void obtenerPorVendedor() {
        //EXISTEN PRODUCTOS GUARDADOS
        //Dado que me encuentro en mi cuenta principal
        //Cuando haga click en el botón de visualizar mis productos
        List<Producto> productos=productoService.obtenerPorVendedor((long) 1);
        //Entonces se mostrarán todos los productos que se hayan guardado
        Assert.notEmpty(productos);
    }

    @Test
    public void obtenerPorVendedor1() {
        //NO EXISTEN PRODUCTOS GUARDADOS
        //Dado que me encuentro en mi cuenta principal
        //Cuando haga click en el botón de visualizar mis productos
        List<Producto> productos=productoService.obtenerPorVendedor((long) 2);
        //Entonces se mostrará un mensaje de error diciendo que no existen productos guardados
        assertEquals(productos.size(),0);
    }

    @Test
    public void getProduct() throws Exception {
        Producto producto=productoService.getProduct((long)2);
        assertNotNull(producto);
        assertEquals(producto.getName(),"CocaCola");
    }

    @Test
    public void updateProduct() throws Exception {
        //LLENÓ TODOS LOS CAMPOS
        Producto producto=new Producto();
        producto.setName("InkaCola");
        producto.setPrice(3.0);
        producto.setDescription("Bebida gasificada");
        producto.setTags("Gaseosa Bebida");
        producto.setStock(5);
        Producto p=productoService.updateProduct((long)3,producto);

        assertEquals(p.getPrice(),3.0,.1);
        assertEquals(p.getName(),"InkaCola");
        assertEquals(p.getDescription(),"Bebida gasificada");
        assertEquals(p.getTags(),"Gaseosa Bebida");
        assertEquals(p.getStock(),5,.1);
    }

    @Test
    public void updateProduct1() throws Exception {
        //NO LLENÓ TODOS LOS CAMPOS
        Producto producto=new Producto();
        producto.setName("InkaCola");
        producto.setPrice(3.0);
        producto.setDescription("Bebida gasificada");
        producto.setTags("Gaseosa Bebida");
        producto.setStock(5);
        Producto p=productoService.updateProduct((long)3,producto);

        assertNotNull(p.getPrice());
        assertNotNull(p.getName());
        assertNotNull(p.getDescription());
        assertNotNull(p.getTags());
        assertNotNull(p.getStock());
    }

    @Test
    public void updateStock() throws Exception {

        Producto producto=new Producto();
        producto.setStock(5);
        Producto p= productoService.updateStock((long)2,producto);
        assertEquals(p.getStock(),5,.1);

    }
    @Test
    public void updateStock1() throws Exception {
        Producto producto=new Producto();
        producto.setStock(5);
        Producto p= productoService.updateStock((long)5,producto);
        assertNotNull(p.getStock());
    }

    @Test
    void deleteProduct() throws Exception {
        Producto producto =productoService.deleteProduct((long) 5);
        Assert.notNull(producto.getIdProducto());

    }

    @Test
    void busquedaPorNombre() {
        List <Producto> producto=productoService.busquedaPorNombre("Bebida");
        Assert.notEmpty(producto);
    }

    @Test
    void filtrarPorPrecio() {
        List<Producto> producto=productoService.filtrarPorPrecio(2.0,10.0);
        Assert.notEmpty(producto);
    }

    @Test
    void listProducts() {
        List<Producto> producto=productoService.listProducts();
        Assert.notEmpty(producto);
    }

    @Test
    void getProductoById(){
        Producto producto=productoService.obtenerProductoporId((long)2);
        Assert.notNull(producto);

    }
}