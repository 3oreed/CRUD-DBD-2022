package dbd.LAB.crud.models;

public class Tienda {
    private int idTienda;
    private String nombreTienda;
    private int edadMinima;
    private int postalCode;
    private int tipoEmpresa;
    private int idEmpresa;

    //Constructor

    public Tienda(int idTienda, String nombreTienda, int edadMinima,
                  int postalCode, int tipoEmpresa, int idEmpresa) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.edadMinima = edadMinima;
        this.postalCode = postalCode;
        this.tipoEmpresa = tipoEmpresa;
        this.idEmpresa = idEmpresa;
    }
    //Getters

    public int getIdTienda() {
        return idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getTipoEmpresa() {
        return tipoEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }
    //Setters

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setTipoEmpresa(int tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
