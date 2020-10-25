package com.hb.comoencasa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Comprador")
public class Comprador implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2383841434344119378L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComprador;
    private String name;
    private String lastname;
    @Column(unique = true)
    private String username;
    private String date;
    @Column(unique = true, length = 8)
    private String dni;
    private String n_mobile;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private byte[] photo;
    
    @OneToMany(mappedBy = "comprador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lista_Producto> lista_producto;

    @OneToMany(mappedBy = "comprador",fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Resena> lista_resena;

    @OneToMany(mappedBy = "comprador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Factura> Facturas;
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Resena> getLista_resena() {
        return lista_resena;
    }

    public void setLista_resena(List<Resena> lista_resena) {
        this.lista_resena = lista_resena;
    }

    public List<Factura> getFacturas() {
        return Facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        Facturas = facturas;
    }

    public List<Lista_Producto> getLista_producto() {
        return lista_producto;
    }

    public void setLista_producto(List<Lista_Producto> lista_producto) {
        this.lista_producto = lista_producto;
    }

    public Long getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Long idComprador) {
        this.idComprador = idComprador;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getN_mobile() {
        return n_mobile;
    }

    public void setN_mobile(String n_mobile) {
        this.n_mobile = n_mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
