package com.hb.comoencasa.adapters.primary;

import com.hb.comoencasa.domain.Producto;
import com.hb.comoencasa.domain.ProductoDTO;
import com.hb.comoencasa.domain.Resena;
import com.hb.comoencasa.ports.primary.ProductoService;
import com.hb.comoencasa.ports.primary.RoleService;
import com.hb.comoencasa.ports.primary.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping ("/producto")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ProductoRest {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //@Autowired
    //private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @GetMapping("/obtener")
    public List<Producto> listar (){
        return productoService.listProducts();
    }
    @Transactional
    @GetMapping("/listar")
    public Stream<ProductoDTO> listarProductos (){
        return productoService.listProducts().stream().map(ProductoDTO::new);
    }

    @GetMapping ("/listar/{id}")
    public Producto obtenerProducto (@PathVariable(value="id") Long id){
        Producto p=null;
        try{
            p=productoService.getProduct(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró producto");
        }
        return p;
    }

    @GetMapping ("/obtener/{id}")
    public ProductoDTO obtenerProductoDTO (@PathVariable(value="id") Long id){
        Producto p=null;
        ProductoDTO productoDTO = null;
        try{
            p=productoService.getProduct(id);
            productoDTO = new ProductoDTO(p);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró producto");
        }
        return productoDTO;
    }

    @PutMapping("/actualizar/{id}")
    public Producto actualizarProducto(@PathVariable(value = "id") Long id, @RequestBody Producto producto) throws Exception{
        Producto p = null;
        try {
            p = productoService.updateProduct(id,producto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo concretar");
        }
        return p;
    }

    @PutMapping("/actualizarStock/{id}")
    public Producto actualizarStock (@PathVariable(value="id")Long id,@RequestBody Producto producto) throws Exception{
        Producto p=null;
        try{
            p=productoService.updateProduct(id,producto);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se pudo concretar");
        }
        return p;

    }

    @DeleteMapping("/eliminar/{id}")
    public Producto eliminarProducto(@PathVariable(value = "id") Long id) throws Exception {
        Producto p = null;
        try {
            p = productoService.deleteProduct(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo concretar");
        }
        return p;
    }
    
    @GetMapping ("/buscar/{name}")
    public List<Producto> buscarPorNombre(@PathVariable(value="name")String nombre){
        return productoService.busquedaPorNombre(nombre);
    }

    @GetMapping ("/buscar/{low}/{high}")
    public List<Producto> filtrarPrecio (@PathVariable(value="low")Double f, @PathVariable (value="high")Double s){
        return productoService.filtrarPorPrecio(f,s);
    }

    @GetMapping ("/obtener/vendedor/{id}")
    public List<Producto>  obtenerPorVendedor (@PathVariable(value="id") Long Id){
        return productoService.obtenerPorVendedor(Id);
    }
    @GetMapping("/resena/listar/{id}")
    public List<Resena> listarResenaPorProducto(@PathVariable(value = "id") Long Id){
        return productoService.listarResenaPorProducto(Id);
    }

    @GetMapping("/categoria/{nCategoria}")
    public List<Producto> listarPorductoPorCategoria(@PathVariable(value = "nCategoria") String Id){
        return productoService.filtrarPorCategoria(Id);
    }

    @GetMapping("/stars/{id}")
    public List<Integer> obtenerStars(@PathVariable(value="id")Long Id){
        return productoService.obtenerStars(Id);
    }
    
    @PostMapping("/upload_imagen_producto/{id}")
    public ProductoDTO CargarImagenProducto(@RequestParam("imageFile") MultipartFile file, @PathVariable(value = "id")Long id)throws Exception{
        return productoService.cargarImagenProducto(file,id);
    }
}
