package com.hb.comoencasa.adapters.primary;

import com.hb.comoencasa.domain.*;
import com.hb.comoencasa.ports.primary.RoleService;
import com.hb.comoencasa.ports.primary.UserService;
import com.hb.comoencasa.ports.primary.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class VendedorRest {
    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    //@Autowired
    //private AuthService authService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @PostMapping("/registrar")
    public Vendedor registrar(@RequestBody Vendedor vendedor){
        Vendedor v = null;
        User u = new User();
        try{
            v  = vendedor;
            vendedorService.registrar(v);
            u.setId(v.getIdVendedor());
            u.setEnabled(true);
            u.setUsername(v.getUsername());
            u.setPassword(encoder.encode(v.getPassword()));
            List<Role> roles = new ArrayList<Role>();
            roles.add(roleService.getRole("ROLE_ADMIN"));
            u.setRoles(roles);
            userService.registar(u);
            return v;

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede registrar un Vendedor");
        }
    }

    @PostMapping("/producto/registrar/{id}")
    public Producto registrarProducto(@RequestBody Producto producto, @PathVariable(value = "id") Long Id) {
        try {
            Producto p = producto;
            return vendedorService.registrarProducto(p,Id);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/factura/obtener/{id}")
    public List<Factura> obtenerFacturas(@PathVariable(value = "id") Long Id){
        return vendedorService.obtenerFporVendedor(Id);
    }

    @GetMapping("/resena/listar/{id}")
    public List<Resena> obtenerResenas(@PathVariable(value = "id") Long Id){
        return vendedorService.obtenerRporVendedor(Id);
    }
}
