package com.hb.comoencasa.domain;

public class ResenaDTO {
    private Long idResena;
    private String comentary;
    private String date;
    private int stars;

    public ResenaDTO() {

    }

    public ResenaDTO(Resena resena) {
        this.idResena = resena.getIdResena();
        this.comentary = resena.getComentary();
        this.date = resena.getDate();
        this.stars = resena.getStars();
    }

    public Long getIdResena() {
        return idResena;
    }

    public void setIdResena(Long idResena) {
        this.idResena = idResena;
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
