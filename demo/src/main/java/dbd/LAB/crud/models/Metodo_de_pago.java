package dbd.LAB.crud.models;

public class Metodo_de_pago {

    private int id_tipopago;
    private String nombre_metodo;

    //Contructor
    public Metodo_de_pago(int id_tipo_de_pago, String nombre_metodo){
        this.id_tipopago = id_tipo_de_pago;
        this.nombre_metodo = nombre_metodo;

    }

    //Getters

    public int getId_tipopago() {
        return id_tipopago;
    }

    public String getNombre_metodo() {
        return nombre_metodo;
    }

    //Setters

    public void setId_tipo_de_pago(int id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public void setNombre_metodo(String nombre_metodo) {
        this.nombre_metodo = nombre_metodo;
    }
}
