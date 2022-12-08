package dbd.LAB.crud.models;

public class TiendaAdmin {
    private int idTiendaAdmin;
    private int idAdmin;
    private int idTienda;

    //Constructor
    public TiendaAdmin(int idTiendaAdmin, int idAdmin, int idTienda) {
        this.idTiendaAdmin = idTiendaAdmin;
        this.idAdmin = idAdmin;
        this.idTienda = idTienda;
    }
    //Getters

    public int getIdTiendaAdmin() {
        return idTiendaAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public int getIdTienda() {
        return idTienda;
    }
    //Setters

    public void setIdTiendaAdmin(int idTiendaAdmin) {
        this.idTiendaAdmin = idTiendaAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
}
