package dbd.LAB.crud.services;
package dbd.LAB.crud.services;
import dbd.LAB.crud.models.ProductoCarrito;
import dbd.LAB.crud.repositories.ProductoCarritoRepository;


import dbd.LAB.crud.repositories.ProductoCarritoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class ProductoCarritoService implements ProductoCarritoRepository{
    private final dbd.LAB.crud.repositories.ProductoCarritoRepository ProductoCarritoRepository;

    ProductoCarritoService(@Lazy ProductoCarritoRepository P_roductoCarritoRepository){
        this.ProductoCarritoRepository = P_roductoCarritoRepository;
    }

    @Override
    public ProductoCarrito crear(ProductoCarrito ProductoCarrito) {
        return null;
    }

    @Override
    public String update(ProductoCarrito ProductoCarrito, int id) {
        return null;
    }

    @Override
    public List<ProductoCarrito> getAll() {
        return null;
    }

    @Override
    public List<ProductoCarrito> show(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
