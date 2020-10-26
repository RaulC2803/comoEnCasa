package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Factura;
import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.domain.Vendedor;
import com.hb.comoencasa.ports.secondary.VendedorRepository;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Access;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class VendedorServiceTest {

    @MockBean
    VendedorRepository vendedorRepository;

    @Autowired()
    VendedorService vendedorService;

    @Autowired
    ProductoService productoService;

    @Test
    void registrar() throws Exception {

    }

    @Test
    public void obtenerVendedor() throws Exception {
        Long vendedorId=334325423554L;
        Vendedor vendedor = new Vendedor() ;

        Optional<Vendedor> vendedorOptional = Optional.of(vendedor);
        when(vendedorRepository.findById(vendedorId)).thenReturn(vendedorOptional);
        //Cuando
        Vendedor v=vendedorService.obtenerVendedor(vendedorId);

        assertNotNull(v);
    }

    @Test
    void registrarProducto() {

    }

    @Test
    void obtenerPporVendedor() {

        Long vendedorID=324L;
        Vendedor vendedor=new Vendedor();

        Optional<Vendedor> vendedorOptional = Optional.of(vendedor);
        when(vendedorRepository.findById(vendedorID)).thenReturn(vendedorOptional);

        List<Producto> productos1=productoService.obtenerPorVendedor(vendedorID);
        //Entonces se mostrarán todos los productos que se hayan guardado
        assertNotNull(productos1);
    }

    @Test
    void obtenerFporVendedor() {
        Long vendedorID=324L;
        Vendedor vendedor=new Vendedor();

        Optional<Vendedor> vendedorOptional = Optional.of(vendedor);
        when(vendedorRepository.findById(vendedorID)).thenReturn(vendedorOptional);

        List<Factura> v=vendedorService.obtenerFporVendedor(vendedorID);
        //Entonces se mostrarán todos los pro ductos que se hayan guardado
        assertNotNull(v);
    }
}