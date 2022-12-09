package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.ProductoCarrito;
import java.util.List;

public interface ProductoCarritoRepository {
    public ProductoCarrito crear(ProductoCarrito ProductoCarrito);
    public String update(ProductoCarrito ProductoCarrito, String id);
    public List<ProductoCarrito> getAll();
    public List<ProductoCarrito> show(String id);
    public void delete(String id);
}
