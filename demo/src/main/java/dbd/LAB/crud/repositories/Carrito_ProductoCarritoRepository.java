package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Carrito_ProductoCarrito;
import java.util.List;

public interface Carrito_ProductoCarritoRepository {
    public Carrito_ProductoCarrito crear(Carrito_ProductoCarrito Carrito_ProductoCarrito );
    public String update(Carrito_ProductoCarrito Carrito_ProductoCarrito , int id);
    public List<Carrito_ProductoCarrito> getAll();
    public List<Carrito_ProductoCarrito> show(int id);
    public void delete(int id);
}
