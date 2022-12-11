package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Valoracion;
import dbd.LAB.crud.repositories.ValoracionRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class ValoracionService {

    private final ValoracionRepository valoracionRepository;

    public ValoracionService(@Lazy ValoracionRepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }

    @PostMapping("/Valoracion")
    @ResponseBody
    public Valoracion crear(@RequestBody Valoracion valoracion){
        Valoracion resultado = valoracionRepository.crear(valoracion);
        return resultado;
    }


    @GetMapping("/Valoracion")
    public List<Valoracion> getAll(){
        return valoracionRepository.getAll();
    }

    @GetMapping("/Valoracion/{id_valoracion}")
    public List<Valoracion> getValoracion(@RequestBody int idvaloracion){
        return valoracionRepository.show(idvaloracion);
    }


    @PutMapping("/Valoracion/{id_valoracion}")
    @ResponseBody
    public String update(@RequestBody Valoracion valoracion,int idvaloracion){
        String retorno = valoracionRepository.update(valoracion,idvaloracion);
        return retorno;
    }

    @DeleteMapping("/Valoracion/{id_valoracion}")
    public void borrar(@PathVariable int idvaloracion){
        valoracionRepository.delete(idvaloracion);
    }
}
