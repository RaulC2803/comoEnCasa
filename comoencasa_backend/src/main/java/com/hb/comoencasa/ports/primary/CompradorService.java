package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Comprador;
import com.hb.comoencasa.domain.Factura;
import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.ports.secondary.CompradorRepository;
import com.hb.comoencasa.ports.secondary.FacturaRepository;
import com.hb.comoencasa.ports.secondary.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import com.hb.comoencasa.ports.secondary.RoleRepository;


@Service
public class CompradorService {
    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;
    //@Autowired
    //private RoleRepository roleRepository;
//
    //@Autowired
    //private cecUserDetailsService CecUserDetailsService;



    public Comprador register(Comprador comprador) throws Exception {
       Comprador c = null;
       c = comprador;

       if(c == null){
           throw new Exception("No se pudo registrar");
       }else{
           System.out.println("Comprador Registrado");
           return compradorRepository.save(c);
       }
    }

    public Comprador obtenerComprador(Long Id) throws Exception{
        return compradorRepository.findById(Id).orElseThrow(
            ()->new Exception("No se encontro comprador"));
    }

    public Factura registrarFactura(Factura factura, Long IdC, Long IdP) throws Exception{
        Factura f = null;
        f = factura;
        Comprador c = null;
        c = obtenerComprador(IdC);
        Producto p = null;
        p = productoRepository.findById(IdP).get();
        f.setComprador(c);
        f.setProducto(p);
        f.setSubTotal(p.getPrice());
        f.setTotal((f.getCantidad() * f.getSubTotal()) + f.getEnvio());
        if (p == null || f == null || c == null) throw new Exception("No se pudo registrar");
        else{
            System.out.println("Se registró el producto");
            return facturaRepository.save(f);
        }

    }

    public List<Factura> listarFacturasComprador(Long Id){
        return facturaRepository.facturasComprador(Id);
    }
}
