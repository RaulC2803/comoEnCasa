package com.hb.comoencasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.hb.comoencasa.domain.Categoria;
import com.hb.comoencasa.ports.primary.CategoryService;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void validateACreateCategory(){
        Categoria categoria = new Categoria();
        categoria.setName("Jardin");

        Categoria registro = categoryService.createCategory(categoria);

        assertNotNull(registro);
        assertEquals(registro.getName(), categoria.getName());
    }

    @Test
    public void validateBGetCategories() {
        List<Categoria> lista = categoryService.getCategories();

        assertEquals(lista.size(), 8);
    }
}
