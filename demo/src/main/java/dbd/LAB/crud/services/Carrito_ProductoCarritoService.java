package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Carrito_ProductoCarrito;
import dbd.LAB.crud.repositories.Carrito_ProductoCarritoRepository;


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
public class Carrito_ProductoCarritoService {
    private final Carrito_ProductoCarritoRepository Carrito_ProductoCarritoRepository;

    Carrito_ProductoCarritoService(@Lazy Carrito_ProductoCarritoRepository Carrito_ProductoCarritoRepository){
        this.Carrito_ProductoCarritoRepository = Carrito_ProductoCarritoRepository;
    }

    // crear C
    @PostMapping("/Carrito_ProductoCarrito")
    @ResponseBody
    public Carrito_ProductoCarrito crear(@RequestBody Carrito_ProductoCarrito Carrito_ProductoCarrito){
        Carrito_ProductoCarrito resultado = Carrito_ProductoCarritoRepository.crear(Carrito_ProductoCarrito);
        return resultado;
    }



    // get R
    @GetMapping("/Carrito_ProductoCarrito")
    public List<Carrito_ProductoCarrito> getAllCarrito_ProductoCarritos(){
        return Carrito_ProductoCarritoRepository.getAll();
    }
    //get by
    @GetMapping("/Carrito_ProductoCarrito/{id}")
    public List<Carrito_ProductoCarrito> getCategoria(@PathVariable int id){
        return Carrito_ProductoCarritoRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Carrito_ProductoCarrito/{id}") //{id}(?)
    @ResponseBody
    public String updateCarrito_ProductoCarrito(@RequestBody Carrito_ProductoCarrito Carrito_ProductoCarrito, @PathVariable int id){
        String retorno = Carrito_ProductoCarritoRepository.update(Carrito_ProductoCarrito,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Carrito_ProductoCarrito/{id}")
    public void borrar(@PathVariable int id){
        Carrito_ProductoCarritoRepository.delete(id);
    }
}