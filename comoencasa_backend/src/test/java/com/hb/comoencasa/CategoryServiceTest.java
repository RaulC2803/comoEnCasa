package com.hb.comoencasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.hb.comoencasa.domain.Categoria;
import com.hb.comoencasa.ports.primary.CategoryService;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryServiceTest {
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
