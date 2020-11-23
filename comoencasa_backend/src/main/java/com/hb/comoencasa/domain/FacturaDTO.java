package com.hb.comoencasa.domain;

public class FacturaDTO {
    private Long idFactura;
    private String date;
    private double subTotal;
    private double total;
    private int cantidad;
    private String product_name;
    private String seller_name;

    public FacturaDTO() {
    }

    public FacturaDTO(Factura factura){
        this.idFactura = factura.getIdFactura();
        this.date = factura.getDate();
        this.subTotal = factura.getSubTotal();
        this.total = factura.getTotal();
        this.cantidad = factura.getCantidad();
        this.product_name = factura.getProducto().getName();
        this.seller_name = factura.getProducto().getVendedor().getName();
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }
}
