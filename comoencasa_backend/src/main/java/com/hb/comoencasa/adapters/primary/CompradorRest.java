package com.hb.comoencasa.adapters.primary;

import com.hb.comoencasa.domain.Comprador;
import com.hb.comoencasa.domain.Factura;
import com.hb.comoencasa.domain.Lista_Producto;
import com.hb.comoencasa.domain.Role;
import com.hb.comoencasa.domain.User;
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

@RestController
@RequestMapping("/comprador")
@CrossOrigin(origins = "*")

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
    public List<Factura> listarFacturas(@PathVariable(value = "id") Long Id){
        return compradorService.listarFacturasComprador(Id);
    }


    @PostMapping("/factura/registrar/{idc}/{idp}")
    public Factura registrarFactura(@RequestBody Factura factura, @PathVariable(value = "idc") Long IdC, @PathVariable(value = "idp") Long IdP){
        Factura f = null;
        try{
            f = factura;
            return compradorService.registrarFactura(f,IdC,IdP);
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
    
}
