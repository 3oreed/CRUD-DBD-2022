package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Carrito;
import dbd.LAB.crud.repositories.CarritoRepository;


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
    private final CarritoRepository CarritoRepository;

    CarritoService(CarritoRepository CarritoRepository){
        this.CarritoRepository = CarritoRepository;
    }

    // crear C
    @PostMapping("/Carrito")
    @ResponseBody
    public Carrito crear(@RequestBody Carrito Carrito){
        Carrito resultado = CarritoRepository.crear(Carrito);
        return resultado;
    }



    // get R
    @GetMapping("/Carrito")
    public List<Carrito> getAllCarritos(){
        return CarritoRepository.getAll();
    }
    //get by
    @GetMapping("/Carrito/{id}")
    public List<Carrito> getCategoria(@PathVariable int id){
        return CarritoRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Categoria/{precio}") //{id}(?)
    @ResponseBody
    public String updateCarrito(@RequestBody Carrito Carrito, @PathVariable int id){
        String retorno = CarritoRepository.update(Carrito,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Categoria/{id}")
    public void borrar(@PathVariable String id){
        CarritoRepository.delete(id);
    }
}