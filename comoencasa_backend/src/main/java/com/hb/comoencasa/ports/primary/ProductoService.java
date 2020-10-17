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

   public Producto register (Producto producto) throws Exception {
       Producto p=producto;

       if (p==null){
           throw new Exception("Producto no registrado");
       } else{
           System.out.println("Registrando producto");
           return productoRepository.save(p);
       }
   }

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
        p.setImages(producto.getImages());
        p.setName(producto.getName());
        p.setTags(producto.getTags());
        return productoRepository.save(p);
    }
    public Producto deleteProduct(Long id) throws Exception {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new Exception("No se encontro producto"));
        productoRepository.delete(producto);
        return producto;
    }
}
