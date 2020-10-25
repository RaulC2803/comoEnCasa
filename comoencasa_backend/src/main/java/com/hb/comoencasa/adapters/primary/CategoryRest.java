package com.hb.comoencasa.adapters.primary;

import com.hb.comoencasa.domain.Categoria;
import com.hb.comoencasa.ports.primary.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryRest {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public Categoria createCategory(@RequestBody Categoria c){
        try {
            return categoryService.createCategory(c);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.MULTI_STATUS, "No se pudo crear la categoría");
        }
    }

    @GetMapping("/get")
    public List<Categoria> getCategories(){
        return categoryService.getCategories();
    }
}
