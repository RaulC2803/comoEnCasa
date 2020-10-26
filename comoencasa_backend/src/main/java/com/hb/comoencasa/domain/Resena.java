package com.hb.comoencasa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Reseña")
public class Resena implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1822968031232739002L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResena;
    private String comentary;
    private String date;
    private int stars;

    @ManyToOne()
    @JoinColumn(name="compradorID")
    private Comprador comprador;

    @ManyToOne()
    @JoinColumn (name="productoID")
    private Producto producto;

    public Long getIdResena() {
        return idResena;
    }

    public void setIdResena(Long idResena) {
        this.idResena = idResena;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getComentary() {
        return comentary;
    }

    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
