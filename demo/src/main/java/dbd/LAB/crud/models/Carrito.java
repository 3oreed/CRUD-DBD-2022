package dbd.LAB.crud.models;

public class Carrito {
    private int id_Carrito;
    private int cantidad_productos;
    private int subtotal;

    public Carrito(int id_Crrito, int cantidad_productos, int subtotal) {
        this.id_Carrito = id_Carrito;
        this.cantidad_productos = cantidad_productos;
        this.subtotal = subtotal;
    }

    public int getId_Carrito() {
        return id_Carrito;
    }

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
