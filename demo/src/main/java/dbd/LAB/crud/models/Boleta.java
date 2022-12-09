package dbd.LAB.crud.models;

public class Boleta {
    private int id_Boleta;
    private int id_pago;
    private String detalle_compra;

    public Boleta(int id_Boleta, int id_pago, String detalle_compra) {
        this.id_Boleta = id_Boleta;
        this.id_pago = id_pago;
        this.detalle_compra = detalle_compra;
    }

    public int getId_Boleta() {
        return id_Boleta;
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
