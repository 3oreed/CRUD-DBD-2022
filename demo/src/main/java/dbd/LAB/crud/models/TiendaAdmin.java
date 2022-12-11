package dbd.LAB.crud.models;

public class TiendaAdmin {
    private int id_tienda_admin;
    private int id_admin;
    private int id_tienda;

    //Constructor
    public TiendaAdmin(int id_tienda_admin, int id_admin, int id_tienda) {
        this.id_tienda_admin = id_tienda_admin;
        this.id_admin = id_admin;
        this.id_tienda = id_tienda;
    }
    //Getters

    public int getId_tienda_admin() {
        return id_tienda_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_tienda() {
        return id_tienda;
    }
    //Setters

    public void setId_tienda_admin(int id_tienda_admin) {
        this.id_tienda_admin = id_tienda_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }
}
