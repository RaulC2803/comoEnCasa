package com.hb.comoencasa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Reseña")
public class Resena implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResena;
    private String comentary;
    private String date;
    private int stars;
}
