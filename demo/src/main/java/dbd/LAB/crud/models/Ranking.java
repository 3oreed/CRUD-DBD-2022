package dbd.LAB.crud.models;

public class Ranking {
    private int idRanking;
    private String nombreEmpresa;
    private int lugarRanking;

    //Constructor
    public Ranking(int idRanking, String nombreEmpresa, int lugarRanking) {
        this.idRanking = idRanking;
        this.nombreEmpresa = nombreEmpresa;
        this.lugarRanking = lugarRanking;
    }
    //Getters

    public int getIdRanking() {
        return idRanking;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public int getLugarRanking() {
        return lugarRanking;
    }
    //Setters

    public void setIdRanking(int idRanking) {
        this.idRanking = idRanking;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setLugarRanking(int lugarRanking) {
        this.lugarRanking = lugarRanking;
    }
}
