package com.hb.comoencasa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatagoria;
    private String name;

    public Long getIdCatagoria() {
        return idCatagoria;
    }

    public void setIdCatagoria(Long idCatagoria) {
        this.idCatagoria = idCatagoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
