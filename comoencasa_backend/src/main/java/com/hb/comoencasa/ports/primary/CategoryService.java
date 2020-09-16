package com.hb.comoencasa.ports.primary;

import com.hb.comoencasa.domain.Categoria;
import com.hb.comoencasa.ports.secondary.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria createCategory(Categoria c){
        return categoriaRepository.save(c);
    }

    public List<Categoria> getCategories(){
        return categoriaRepository.findAll();
    }
}
