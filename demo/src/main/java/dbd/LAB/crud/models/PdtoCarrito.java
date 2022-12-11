package dbd.LAB.crud.models;

public class PdtoCarrito {
    private int id_item_carrito;
    private String nombre;
    private int cantidad;
    private String comentario;

    public PdtoCarrito(int id_item_carrito, String nombre, int cantidad, String comentario) {
        this.id_item_carrito = id_item_carrito;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.comentario = comentario;
    }

    public int getId_item_carrito() {
        return id_item_carrito;
    }

    public void setId_item_carrito(int id_item_carrito) {
        this.id_item_carrito = id_item_carrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
