package com.hb.comoencasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.hb.comoencasa.domain.User;
import com.hb.comoencasa.ports.primary.UserService;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    private User user=new User();

    @Test
    public void validateARegistrar(){
        initUser();
        User registrado = userService.registar(this.user);

        assertEquals(registrado.getUsername(), this.user.getUsername());
    }   

    @Test
    public void validateBFindUserByName(){
        initUser();
        User buscado = userService.findByUsername("ManoPaloSanto1");

       assertNotNull(buscado);
       assertEquals(buscado.getUsername(), this.user.getUsername());
    }

    private void initUser(){

        user.setUsername("ManoPaloSanto1");
    }
}
