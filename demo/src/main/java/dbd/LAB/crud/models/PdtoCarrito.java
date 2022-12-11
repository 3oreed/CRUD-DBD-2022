package dbd.LAB.crud.models;

public class PdtoCarrito {
    private int id_item_carrito;
    private String nombreItem;
    private int cantidadItem;
    private String comentarioItem;

    public PdtoCarrito(int id_item_carrito, String nombreItem, int cantidadItem, String comentarioItem) {
        this.id_item_carrito = id_item_carrito;
        this.nombreItem = nombreItem;
        this.cantidadItem = cantidadItem;
        this.comentarioItem = comentarioItem;
    }

    public int getId_item_carrito() {
        return id_item_carrito;
    }

    public void setId_item_carrito(int id_item_carrito) {
        this.id_item_carrito = id_item_carrito;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getCantidadItem() {
        return cantidadItem;
    }

    public void setCantidadItem(int cantidadItem) {
        this.cantidadItem = cantidadItem;
    }

    public String getComentarioItem() {
        return comentarioItem;
    }

    public void setComentarioItem(String comentarioItem) {
        this.comentarioItem = comentarioItem;
    }
}
