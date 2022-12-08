package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Metodo_de_pago;

import java.util.List;

public interface Metodo_de_pagoRepository {

    public Metodo_de_pago crear(Metodo_de_pago tipo_de_pago);

    public String update(Metodo_de_pago tipo_de_pago, int id_tipo_de_pago);

    public List<Metodo_de_pago> getAll();

    public List<Metodo_de_pago> show(int id_tipo_de_pago);

    public void delete(int id_tipo_de_pago);
}

