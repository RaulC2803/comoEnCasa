package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Role;
import org.junit.FixMethodOrder;
import  org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void getRole() {
        Role role=roleService.getRole("admin");
        assertNotNull(role);
    }
}