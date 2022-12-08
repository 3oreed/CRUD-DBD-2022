package dbd.LAB.crud.models;

public class Boleta {
    private int id_boleta;
    private int id_pago;
    private String detalle_compra;

    public Boleta(int id_boleta, int id_pago, String detalle_compra) {
        this.id_boleta = id_boleta;
        this.id_pago = id_pago;
        this.detalle_compra = detalle_compra;
    }

    public int getId_boleta() {
        return id_boleta;
    }

    public int getId_pago() {
        return id_pago;
    }

    public String getDetalle_compra() {
        return detalle_compra;
    }

    public void setId_boleta(int id_boleta) {
        this.id_boleta = id_boleta;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public void setDetalle_compra(String detalle_compra) {
        this.detalle_compra = detalle_compra;
    }
}
