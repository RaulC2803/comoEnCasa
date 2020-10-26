package com.hb.comoencasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hb.comoencasa.domain.User;
import com.hb.comoencasa.ports.primary.UserService;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
    private UserService userService;
    private User user;

    @Test
    public void validateARegistrar(){
        initUser();
        User registrado = userService.registar(this.user);

        assertEquals(registrado.getUsername(), this.user.getUsername());
    }   

    @Test
    public void validateBFindUserByName(){
       User buscado = userService.findByUsername(this.user.getUsername());

       assertNotNull(buscado);
       assertEquals(buscado.getId(), this.user.getId());
       assertEquals(buscado.getUsername(), this.user.getUsername());
    }

    private void initUser(){
        this.user = new User();
        user.setUsername("ManoPaloSanto");
    }
}
