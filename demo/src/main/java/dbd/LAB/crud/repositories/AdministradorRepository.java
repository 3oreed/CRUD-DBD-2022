package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Administrador;
import java.util.List;

public interface AdministradorRepository {
    public Administrador crear(Administrador Administrador);
    public String update(Administrador Admnistrador, int id);
    public List<Administrador> getAll();
    public List<Administrador> show(int id);
    public void delete(int id);
}
