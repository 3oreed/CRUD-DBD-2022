package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Metodo_de_pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class Metodo_de_pagolmp implements Metodo_de_pagoRepository {
    @Override
    public Metodo_de_pago crear(Metodo_de_pago tipo_de_pago) {
        return null;
    }

    @Override
    public String update(Metodo_de_pago tipo_de_pago, int id_tipo_de_pago) {
        return null;
    }

    @Override
    public List<Metodo_de_pago> getAll() {
        return null;
    }

    @Override
    public List<Metodo_de_pago> show(int id_tipo_de_pago) {
        return null;
    }

    @Override
    public void delete(int id_tipo_de_pago) {

    }
}
