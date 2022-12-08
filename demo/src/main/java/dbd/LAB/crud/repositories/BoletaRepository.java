package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Boleta;
import java.util.List;

public interface BoletaRepository {
    public Boleta crear(Boleta Boleta);
    public String update(Boleta Boleta, String id);
    public List<Boleta> getAll();
    public List<Boleta> show(String id);
    public void delete(String id);
}
