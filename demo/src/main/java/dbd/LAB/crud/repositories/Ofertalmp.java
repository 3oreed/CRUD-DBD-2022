package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class Ofertalmp implements OfertaRepository {
    @Override
    public Oferta crear(Oferta oferta) {
        return null;
    }

    @Override
    public String update(Oferta oferta, int id_oferta) {
        return null;
    }

    @Override
    public List<Oferta> getAll() {
        return null;
    }

    @Override
    public List<Oferta> show(int id_oferta) {
        return null;
    }

    @Override
    public void delete(int id_oferta) {

    }
}
