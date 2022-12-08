package dbd.LAB.crud.models;

public class Valoracion {
    private int idValoracion;
    private int puntuacion;
    private String opinion;
    private Boolean favoritos;
    private int idCliente;
    private int idEmpresa;

    //Constructor
    public Valoracion(int idValoracion, int puntuacion, String opinion,
                      Boolean favoritos, int idCliente, int idEmpresa) {
        this.idValoracion = idValoracion;
        this.puntuacion = puntuacion;
        this.opinion = opinion;
        this.favoritos = favoritos;
        this.idCliente = idCliente;
        this.idEmpresa = idEmpresa;
    }
    //Getters

    public int getIdValoracion() {
        return idValoracion;
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

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    //Setters
    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
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

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
