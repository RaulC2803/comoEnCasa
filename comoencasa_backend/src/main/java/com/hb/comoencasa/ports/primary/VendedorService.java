package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.*;

import com.hb.comoencasa.domain.Factura;
import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.domain.Vendedor;
import com.hb.comoencasa.ports.secondary.FacturaRepository;
import com.hb.comoencasa.ports.secondary.ProductoRepository;
import com.hb.comoencasa.ports.secondary.ResenaRepository;
import com.hb.comoencasa.ports.secondary.VendedorRepository;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ResenaRepository resenaRepository;

    public Vendedor registrar(Vendedor vendedor) throws Exception {
        Vendedor v = null;
        v = vendedor;

        if(v == null){
            throw new Exception("No se pudo registrar");
        }else{
            System.out.println("Vendedor Registrado");
            return vendedorRepository.save(v);
        }
    }

    public Vendedor obtenerVendedor(Long Id) throws Exception {
        Vendedor v;
        v = vendedorRepository.findById(Id).get();
        if(v == null) throw new Exception("El vendedor no existe");
        return v;
    }


    @Transactional(rollbackFor = Exception.class)
    public Producto registrarProducto(Producto producto, Long Id) throws Exception{
        Producto p = null;
        p = producto;
        Vendedor v = null;
        v = obtenerVendedor(Id);
        p.setVendedor(v);
        if (p == null || v == null) throw new Exception("No se pudo registrar");
        else{
            System.out.println("Se registró el producto");
            return productoRepository.save(p);
        }
    }

    public List<Producto> obtenerPporVendedor(Long id){
        return productoRepository.productosVendedor(id);
    }

    public List<Factura> obtenerFporVendedor(Long Id) {
        return facturaRepository.facturasVendedor(Id);
    }

    public List<Resena> obtenerRporVendedor(Long Id){ return resenaRepository.resenasVendedor(Id); }
}
