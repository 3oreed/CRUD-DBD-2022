package dbd.LAB.crud.models;

public class Ranking {
    private int id_ranking;
    private String nombre_empresa;
    private int lugar;

    //Constructor
    public Ranking(int id_ranking, String nombre_empresa, int lugar) {
        this.id_ranking = id_ranking;
        this.nombre_empresa = nombre_empresa;
        this.lugar = lugar;
    }
    //Getters

    public int getId_ranking() {
        return id_ranking;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public int getLugar() {
        return lugar;
    }
    //Setters

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public void setLugar(int lugar) {
        this.lugar = lugar;
    }
}
