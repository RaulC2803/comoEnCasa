package com.hb.comoencasa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Producto")
public class Producto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5692494217372834410L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String name;
    private double price;
    private String description;
    private String images;
    private String tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
