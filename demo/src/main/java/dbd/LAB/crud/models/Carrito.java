package dbd.LAB.crud.models;

public class Carrito {
    private int id_Carrito;
    private int cantidad_productos;
    private int total;

    public Carrito(int id_Crrito, int cantidad_productos, int total) {
        this.id_Carrito = id_Carrito;
        this.cantidad_productos = cantidad_productos;
        this.total = total;
    }

    public int getId_Carrito() {
        return id_Carrito;
    }

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public int getTotal() {
        return total;
    }

    public void setId_Carrito(int id_Carrito) {
        this.id_Carrito = id_Carrito;
    }

    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
