package dbd.LAB.crud.models;

public class Valoracion {
    private int id_valoracion;
    private int puntuacion;
    private String opinion;
    private Boolean favoritos;
    private int id_cliente;
    private int id_empresa;

    //Constructor
    public Valoracion(int id_valoracion, int puntuacion, String opinion,
                      Boolean favoritos, int id_cliente, int id_empresa) {
        this.id_valoracion = id_valoracion;
        this.puntuacion = puntuacion;
        this.opinion = opinion;
        this.favoritos = favoritos;
        this.id_cliente = id_cliente;
        this.id_empresa = id_empresa;
    }
    //Getters

    public int getId_valoracion() {
        return id_valoracion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getOpinion() {
        return opinion;
    }

    public Boolean getFavoritos() {
        return favoritos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    //Setters
    public void setId_valoracion(int id_valoracion) {
        this.id_valoracion = id_valoracion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public void setFavoritos(Boolean favoritos) {
        this.favoritos = favoritos;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }
}
