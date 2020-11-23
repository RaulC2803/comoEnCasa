package com.hb.comoencasa.domain;

import javax.persistence.Column;

public class CompradorDTO {
    private Long idComprador;
    private String name;
    private String lastname;
    private String n_mobile;
    private String email;
    private String address;

    public CompradorDTO(){

    }
    public CompradorDTO(Comprador comprador){
        this.idComprador = comprador.getIdComprador();
        this.name = comprador.getName();
        this.lastname = comprador.getLastname();
        this.n_mobile = comprador.getN_mobile();
        this.email = comprador.getEmail();
        this.address = comprador.getAddress();
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


