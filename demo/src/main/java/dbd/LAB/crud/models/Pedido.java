package dbd.LAB.crud.models;


public class Pedido {

    private int id_pedido;
    private int subtotal;
    private String tipo_entrega;
    private String ubicacion;
    private int id_pago;
    private int id_cliente;

    //Contructor

    public Pedido(int id_pedido, int subtotal, String tipo_entrega, String ubicacion, int id_pago, int id_cliente) {
        this.id_pedido = id_pedido;
        this.subtotal = subtotal;
        this.tipo_entrega = tipo_entrega;
        this.ubicacion = ubicacion;
        this.id_pago = id_pago;
        this.id_cliente = id_cliente;
    }

    //Getters

    public int getId_pedido() {
        return id_pedido;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public String getTipo_entrega() {
        return tipo_entrega;
    }

    public String getUbicacion() {
        return ubicacion;
    }


    public int getId_pago() {
        return id_pago;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    //Setters


    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public void setTipo_entrega(String tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
