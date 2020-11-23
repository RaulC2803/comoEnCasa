package com.hb.comoencasa.domain;

public class ProductoDTO {
    private Long idProducto;
    private String name;
    private double price;
    private String description;
    private String categoria;
    private String images;
    private String tags;
    private double stock;
    private Long idVendedor;
    private String nameVendedor;
    private String addressVendedor;
    private String n_mobileVendedor;
    private String emailVendedor;

    public ProductoDTO (){

    }

    public ProductoDTO(Producto producto){
        this.name = producto.getName();
        this.idProducto = producto.getIdProducto();
        this.price = producto.getPrice();
        this.description = producto.getDescription();
        this.categoria = producto.getCategoria();
        this.images = producto.getImages();
        this.tags = producto.getTags();
        this.stock = producto.getStock();
        this.idVendedor = producto.getVendedor().getIdVendedor();
        this.nameVendedor = producto.getVendedor().getName();
        this.addressVendedor = producto.getVendedor().getAddress();
        this.n_mobileVendedor = producto.getVendedor().getN_mobile();
        this.emailVendedor = producto.getVendedor().getEmail();
    }

    public String getAddressVendedor() {
        return addressVendedor;
    }

    public void setAddressVendedor(String addressVendedor) {
        this.addressVendedor = addressVendedor;
    }

    public String getN_mobileVendedor() {
        return n_mobileVendedor;
    }

    public void setN_mobileVendedor(String n_mobileVendedor) {
        this.n_mobileVendedor = n_mobileVendedor;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }

    public String getNameVendedor() {
        return nameVendedor;
    }

    public void setNameVendedor(String nameVendedor) {
        this.nameVendedor = nameVendedor;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }
}
