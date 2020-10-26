package com.hb.comoencasa.domain;

import javax.persistence.*;


@Entity
@Table(name = "Lista_Producto")
public class                                                                                                                                                                                                                                        Lista_Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Boolean agregado;
    private int cantidad;



    @ManyToOne()
    @JoinColumn(name = "Producto_Id")
    private Producto producto;

    @ManyToOne()
    @JoinColumn(name = "Comprador_Id")
    private Comprador comprador;

    public Boolean getAgregado() {
        return agregado;
    }

    public void setAgregado(Boolean agregado) {
        this.agregado = agregado;
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
