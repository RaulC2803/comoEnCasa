package com.hb.comoencasa;

import com.hb.comoencasa.domain.User;
import com.hb.comoencasa.ports.primary.AuthService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthServiceTest {

    @Autowired
    private AuthService userService;
    private User user=new User();

    @Test
    public void validateARegistrar(){
        initUser();
        User registrado = userService.RegisterUser(this.user);

        assertEquals(registrado.getUsername(), this.user.getUsername());
    }

    private void initUser(){

        user.setUsername("25ManoPaloSan2to1");
    }
}