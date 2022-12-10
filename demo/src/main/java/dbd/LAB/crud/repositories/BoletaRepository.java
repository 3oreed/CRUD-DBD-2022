package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Boleta;
import java.util.List;

public interface BoletaRepository {
    public Boleta crear(Boleta Boleta);
    public String update(Boleta Boleta, int id_boleta);
    public List<Boleta> getAll();
    public List<Boleta> show(int id_boleta);
    public void delete(int id_boleta);
}
