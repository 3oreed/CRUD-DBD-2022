package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Empresa_Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class Empresa_administradorlmp implements Empresa_administradorRepository {

    @Override
    public Empresa_Administrador crear(Empresa_Administrador Empresa_admin) {
        return null;
    }

    @Override
    public String update(Empresa_Administrador Empresa_admin, int id_empresa_Administrador) {
        return null;
    }

    @Override
    public List<Empresa_Administrador> getAll() {
        return null;
    }

    @Override
    public List<Empresa_Administrador> show(int id_empresa_Administrador) {
        return null;
    }

    @Override
    public void delete(int id_empresa_Administrador) {

    }
}
