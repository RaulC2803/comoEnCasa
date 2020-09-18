package com.hb.comoencasa.adapters.primary;

import com.hb.comoencasa.domain.Comprador;
import com.hb.comoencasa.domain.Role;
import com.hb.comoencasa.domain.User;
import com.hb.comoencasa.ports.primary.AuthService;
import com.hb.comoencasa.ports.primary.CompradorService;
import com.hb.comoencasa.ports.primary.RoleService;
import com.hb.comoencasa.ports.primary.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comprador")
public class CompradorRest {
    @Autowired
    private CompradorService compradorService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

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
}
