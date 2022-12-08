package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Carrito;
import java.util.List;

public interface CarritoRepository {
    public Carrito crear(Carrito Carrito);
    public String update(Carrito Carrito, String id);
    public List<Carrito> getAll();
    public List<Carrito> show(String id);
    public void delete(String id);
}
