package dbd.LAB.crud.models;

public class Metodo_de_pago {

    private int id_tipo_de_pago;
    private String nombre_metodo;

    //Contructor
    public Metodo_de_pago(int id_tipo_de_pago, String nombre_metodo){
        this.id_tipo_de_pago = id_tipo_de_pago;
        this.nombre_metodo = nombre_metodo;

    }

    //Getters

    public int getId_tipo_de_pago() {
        return id_tipo_de_pago;
    }

    public String getNombre_metodo() {
        return nombre_metodo;
    }

    //Setters

    public void setId_tipo_de_pago(int id_tipo_de_pago) {
        this.id_tipo_de_pago = id_tipo_de_pago;
    }

    public void setNombre_metodo(String nombre_metodo) {
        this.nombre_metodo = nombre_metodo;
    }
}
