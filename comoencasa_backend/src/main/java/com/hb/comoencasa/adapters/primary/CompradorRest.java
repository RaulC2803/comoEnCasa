package com.hb.comoencasa.adapters.primary;

import com.hb.comoencasa.domain.*;
import com.hb.comoencasa.ports.primary.CompradorService;
import com.hb.comoencasa.ports.primary.RoleService;
import com.hb.comoencasa.ports.primary.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
//import com.hb.comoencasa.ports.primary.AuthService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/comprador")
@CrossOrigin(origins = "*",allowedHeaders = "*")

public class CompradorRest {
    @Autowired
    private CompradorService compradorService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //@Autowired
    //private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @PostMapping("/register")
    public Comprador register(@RequestBody Comprador comprador){
        Comprador c = null;
        User u = new User();
        try{
            c  =comprador;
            compradorService.register(c);
            u.setId(c.getIdComprador());
            u.setEnabled(true);
            u.setUsername(c.getUsername());
            u.setPassword(encoder.encode(c.getPassword()));
            List<Role> roles = new ArrayList<Role>();
            roles.add(roleService.getRole("ROLE_ADMIN"));
            u.setRoles(roles);
            userService.registar(u);
            return c;

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede registrar un Comprador");
        }
    }


    @GetMapping("/factura/listar/{id}")
    public Stream<FacturaDTO> listarFacturas(@PathVariable(value = "id") Long Id){
        return compradorService.listarFacturasComprador(Id).stream().map(FacturaDTO::new);
    }


    @PostMapping("/factura/registrar/{idc}/{idp}")
    public FacturaDTO registrarFactura(@RequestBody Factura factura, @PathVariable(value = "idc") Long IdC, @PathVariable(value = "idp") Long IdP){
        Factura f = null;
        try{
            f = factura;
            FacturaDTO facturaDTO = new FacturaDTO(compradorService.registrarFactura(f,IdC,IdP));
            return facturaDTO;
        } catch(Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/lista/anadir/{idc}/{idp}")
    public Lista_Producto anadirProducto(@RequestBody Lista_Producto lista_producto, @PathVariable(value = "idc") Long IdC, @PathVariable(value = "idp") Long IdP){
        Lista_Producto p = null;
        try{
            p = lista_producto;
            return compradorService.anadirProducto(p, IdC, IdP);
        }catch (Exception e){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/lista/eliminar/{id}")
    public Lista_Producto eliminarProducto(@PathVariable(value = "id") Long id) throws Exception {
        Lista_Producto p = null;
        try {
            p = compradorService.eliminarProductoLista(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo concretar");
        }
        return p;
    }

    @GetMapping("/lista/listar/{id}")
    public List<Lista_Producto> listarProductos(@PathVariable(value = "id")Long Id){
        return compradorService.listarProductosComprador(Id);
    }


    @PostMapping("/resena/anadir/{idc}/{idp}")
    public Resena anadirresena(@RequestBody Resena resena, @PathVariable(value = "idc") Long IdC, @PathVariable(value = "idp") Long IdP){
        Resena r = null;
        try{
            r = resena;
            return compradorService.anadirResena(r,IdC,IdP);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/resena/listar/{id}")
    public List<Resena> listarResenas(@PathVariable(value = "id") Long Id){
        return compradorService.listarResenas(Id);
    }

    @GetMapping ("/get/{id}")
    public CompradorDTO obtenerComprador (@PathVariable(value="id")Long Id) throws Exception{
        CompradorDTO compradorDTO = null;
        compradorDTO = new CompradorDTO(compradorService.obtenerComprador(Id));
        if (compradorDTO == null){
            System.out.println("Se mando mal");
        }else{
            System.out.println("Respuesta correcta");
        }
        return compradorDTO;
    }

}
