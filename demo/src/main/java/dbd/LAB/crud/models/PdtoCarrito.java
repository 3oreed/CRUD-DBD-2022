package dbd.LAB.crud.models;

public class PdtoCarrito {
    private int id_item_carrito;
    private String nombre;
    private int cantidad;
    private String comentario;

    private int precio;
    private int subtotal;
    private int id_carrito;
    private int id_prod;

    public PdtoCarrito(int id_item_carrito, String nombre, int cantidad, String comentario, int precio, int subtotal, int id_carrito, int id_prod) {
        this.id_item_carrito = id_item_carrito;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.precio = precio;
        this.subtotal = subtotal;
        this.id_carrito = id_carrito;
        this.id_prod = id_prod;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }
}
