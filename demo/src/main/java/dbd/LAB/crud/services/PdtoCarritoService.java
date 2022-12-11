package dbd.LAB.crud.services;

import dbd.LAB.crud.models.PdtoCarrito;
import dbd.LAB.crud.repositories.PdtoCarritoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class PdtoCarritoService {
    private final PdtoCarritoRepository PdtoCarritoRepository;

    PdtoCarritoService(@Lazy PdtoCarritoRepository PdtoCarritoRepository){
        this.PdtoCarritoRepository = PdtoCarritoRepository;
    }

    // crear C
    @PostMapping("/PdtoCarrito")
    @ResponseBody
    public PdtoCarrito crear(@RequestBody PdtoCarrito PdtoCarrito){
        PdtoCarrito resultado = PdtoCarritoRepository.crear(PdtoCarrito);
        return resultado;
    }



    // get R
    @GetMapping("/PdtoCarrito")
    public List<PdtoCarrito> getAllPdtoCarritos(){
        return PdtoCarritoRepository.getAll();
    }
    //get by
    @GetMapping("/PdtoCarrito/{id}")
    public List<PdtoCarrito> getPdtoCarrito(@PathVariable int id){
        return PdtoCarritoRepository.show(id);
    }



    // actualizar U
    @PutMapping("/PdtoCarrito/{id}") //{id}(?)
    @ResponseBody
    public String updatePdtoCarrito(@RequestBody PdtoCarrito PdtoCarrito, @PathVariable int id){
        String retorno = PdtoCarritoRepository.update(PdtoCarrito,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/PdtoCarrito/{id}")
    public void borrar(@PathVariable int id){
        PdtoCarritoRepository.delete(id);
    }
}
