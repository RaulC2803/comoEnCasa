package com.hb.comoencasa.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Vendedor")
public class Vendedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVendedor;
    private String name;
    private String date;
    @Column(unique = true, length = 8)
    private String dni;
    private String n_mobile;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private byte[] photo;
}
