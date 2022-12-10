package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.ProductoCarrito;
import java.util.List;

public interface ProductoCarritoRepository {
    public ProductoCarrito crear(ProductoCarrito ProductoCarrito);
    public String update(ProductoCarrito ProductoCarrito, int id);
    public List<ProductoCarrito> getAll();
    public List<ProductoCarrito> show(int id);
    public void delete(int id);
}
