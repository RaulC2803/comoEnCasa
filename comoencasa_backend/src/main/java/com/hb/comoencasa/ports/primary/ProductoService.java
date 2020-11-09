package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.ports.secondary.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
   @Autowired
   private ProductoRepository productoRepository;

   public List <Producto> listProducts (){
       return productoRepository.findAll();
   }

   public Producto getProduct (Long id) throws  Exception{
       return productoRepository.findById(id).orElseThrow(()-> new Exception("No se pudo encontrar producto"));
   }

    public Producto updateProduct(Long id, Producto producto) throws Exception{
        Producto p = productoRepository.findById(id).orElseThrow(() -> new Exception("No se encontro el producto"));
        p.setDescription(producto.getDescription());
        p.setPrice(producto.getPrice());
        p.setName(producto.getName());
        p.setTags(producto.getTags());
        p.setStock(producto.getStock());
        return productoRepository.save(p);
    }
    public Producto updateStock (Long id,Producto producto) throws Exception {
       Producto p=productoRepository.findById(id).orElseThrow(()->new Exception("No se encontro producto"));
       p.setStock(producto.getStock());
       return productoRepository.save(p);
    }

    public Producto deleteProduct(Long id) throws Exception {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new Exception("No se encontro producto"));
        productoRepository.delete(producto);
        return producto;
    }

    public Producto obtenerProductoporId(Long Id){
       return productoRepository.findById(Id).get();
    }

    public List<Producto> busquedaPorNombre(String name){
        return productoRepository.buscar(name);
    }

    public List<Producto> filtrarPorPrecio (Double f, Double s){
       return productoRepository.filtrarPorPrecio(f,s);
    }

    public List<Producto> obtenerPorVendedor (Long id){return productoRepository.productosVendedor(id);
    }

}
