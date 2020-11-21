package com.hb.comoencasa;

import com.hb.comoencasa.adapters.primary.CategoryRest;
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
public class CategoryRestTest {
    @Autowired
    private CategoryRest categoryRest;

    @Test
    public void crear (){

    }

    @Test
    public void obterner(){

    }

}
