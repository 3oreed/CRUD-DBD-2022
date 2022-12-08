package dbd.LAB.crud.models;

public class Carrito_ProductoCarrito {
    private int id_carrito_ProductoCarrito;
    private int  id_item_carrito ;
    private int id_carrito ;

    public Carrito_ProductoCarrito(int id_carrito_ProductoCarrito, int id_item_carrito, int id_carrito) {
        this.id_carrito_ProductoCarrito = id_carrito_ProductoCarrito;
        this.id_item_carrito = id_item_carrito;
        this.id_carrito = id_carrito;
    }

    public int getId_carrito_ProductoCarrito() {
        return id_carrito_ProductoCarrito;
    }

    public int getId_item_carrito() {
        return id_item_carrito;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito_ProductoCarrito(int id_carrito_ProductoCarrito) {
        this.id_carrito_ProductoCarrito = id_carrito_ProductoCarrito;
    }

    public void setId_item_carrito(int id_item_carrito) {
        this.id_item_carrito = id_item_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }
}
