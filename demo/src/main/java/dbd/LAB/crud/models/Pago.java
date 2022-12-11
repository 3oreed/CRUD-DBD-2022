package dbd.LAB.crud.models;

public class Pago {
    private int id_pago;
    private int monto;
    private int id_tipopago;
    private int id_empresa;

    //Constructor

    public Pago(int id_pago, int monto, int id_tipopago, int id_empresa) {
        this.id_pago = id_pago;
        this.monto = monto;
        this.id_tipopago = id_tipopago;
        this.id_empresa = id_empresa;
    }

    //Getters

    public int getId_pago() {
        return id_pago;
    }

    public int getMonto() {
        return monto;
    }

    public int getId_tipopago() {
        return id_tipopago;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    //Setters


    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setId_tipopago(int id_tipopago) {
        this.id_tipopago = id_tipopago;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }
}
