package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Carrito;
import dbd.LAB.crud.repositories.CarritoRepository;


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
public class CarritoService {
    private final CarritoRepository carritoRepository;



    public CarritoService(@Lazy CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    // crear C
    @PostMapping("/Carrito")
    @ResponseBody
    public Carrito crear(@RequestBody Carrito Carrito){
        Carrito resultado = carritoRepository.crear(Carrito);
        return resultado;
    }



    // get R
    @GetMapping("/Carrito")
    public List<Carrito> getAllCarritos(){
        return carritoRepository.getAll();
    }
    //get by
    @GetMapping("/Carrito/{id}")
    public List<Carrito> getCategoria(@PathVariable int id){
        return carritoRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Carrito/{id}") //{id}(?)
    @ResponseBody
    public String updateCarrito(@RequestBody Carrito Carrito, @PathVariable int id){
        String retorno = carritoRepository.update(Carrito,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Carrito/{id}")
    public void borrar(@PathVariable int id){
        carritoRepository.delete(id);
    }
}