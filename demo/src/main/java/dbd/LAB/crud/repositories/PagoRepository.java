package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Pago;

import java.util.List;

public interface PagoRepository {

    public Pago crear(Pago pago);

    public String update(Pago oferta, int id_pago);

    public List<Pago> getAll();

    public List<Pago> show(int id_pago);

    public void delete(int id_pago);

}
