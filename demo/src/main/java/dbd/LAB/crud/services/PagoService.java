package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Pago;
import dbd.LAB.crud.repositories.PagoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(@Lazy PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }
    @PostMapping("/Pago")
    @ResponseBody
    public Pago crear(@RequestBody Pago pago){
        Pago resultado = pagoRepository.crear(pago);
        return resultado;
    }
    @GetMapping("/Pago")
    public List<Pago> getAllpago(){
        return pagoRepository.getAll();
    }
    @GetMapping("/Pago/{id_pago}")
    public List<Pago> getPago(@PathVariable int id_pago) {
        return pagoRepository.show(id_pago);
    }
    @PutMapping("/Pago/{id_pago}") //{id}(?)
    @ResponseBody
    public String updatePago(@RequestBody Pago pago, int id_pago){
        String retorno = pagoRepository.update(pago,id_pago);
        return retorno;
    }
    @DeleteMapping("/Pago/{id_pago}")
    public void borrar(@PathVariable int id_pago){
        pagoRepository.delete(id_pago);
    }

}
