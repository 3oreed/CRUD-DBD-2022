package dbd.LAB.crud.models;

public class Cliente_tienda{
    private int id_cliente_tienda;
    private int id_cliente;
    private int id_tienda;
    private int edad_minima;

    //Contructors
    public Cliente_tienda(int id_cliente_tienda, int id_cliente, int id_tienda, int edad_minima) {
        this.id_cliente_tienda = id_cliente_tienda;
        this.id_cliente = id_cliente;
        this.id_tienda = id_tienda;
        this.edad_minima = edad_minima;
    }

    //Getters

    public int getId_cliente_tienda() {
        return id_cliente_tienda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    //Setters
    public void setId_cliente_tienda(int id_cliente_tienda) {
        this.id_cliente_tienda = id_cliente_tienda;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }
}