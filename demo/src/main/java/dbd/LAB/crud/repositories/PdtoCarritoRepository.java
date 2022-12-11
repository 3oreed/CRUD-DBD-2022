package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.PdtoCarrito;
import java.util.List;


public interface PdtoCarritoRepository {
    public PdtoCarrito crear(PdtoCarrito PdtoCarrito);
    public String update(PdtoCarrito PdtoCarrito, int id);
    public List<PdtoCarrito> getAll();
    public List<PdtoCarrito> show(int id);
    public void delete(int id);
}
