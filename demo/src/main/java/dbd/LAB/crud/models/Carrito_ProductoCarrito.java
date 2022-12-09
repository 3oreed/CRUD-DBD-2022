package dbd.LAB.crud.models;

public class Carrito_ProductoCarrito {
    private int id_Carrito_ProductoCarrito;
    private int  id_item_carrito ;
    private int id_carrito ;

    public Carrito_ProductoCarrito(int id_Carrito_ProductoCarrito, int id_item_carrito, int id_carrito) {
        this.id_Carrito_ProductoCarrito = id_Carrito_ProductoCarrito;
        this.id_item_carrito = id_item_carrito;
        this.id_carrito = id_carrito;
    }

    public int getId_Carrito_ProductoCarrito() {
        return id_Carrito_ProductoCarrito;
    }

    public int getId_item_carrito() {
        return id_item_carrito;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_Carrito_ProductoCarrito(int id_Carrito_ProductoCarrito) {
        this.id_Carrito_ProductoCarrito = id_Carrito_ProductoCarrito;
    }

    public void setId_item_carrito(int id_item_carrito) {
        this.id_item_carrito = id_item_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }
}
