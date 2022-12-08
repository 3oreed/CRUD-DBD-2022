package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class Pagolmp implements PagoRepository{
    @Override
    public Pago crear(Pago pago) {
        return null;
    }

    @Override
    public String update(Pago oferta, int id_pago) {
        return null;
    }

    @Override
    public List<Pago> getAll() {
        return null;
    }

    @Override
    public List<Pago> show(int id_pago) {
        return null;
    }

    @Override
    public void delete(int id_pago) {

    }
}
