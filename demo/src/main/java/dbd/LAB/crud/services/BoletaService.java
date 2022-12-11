package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Boleta;
import dbd.LAB.crud.repositories.BoletaRepository;


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
public class BoletaService {
    private final BoletaRepository BoletaRepository;

    BoletaService(@Lazy BoletaRepository BoletaRepository){
        this.BoletaRepository = BoletaRepository;
    }

    // crear C
    @PostMapping("/Boleta")
    @ResponseBody
    public Boleta crear(@RequestBody Boleta Boleta){
        Boleta resultado = BoletaRepository.crear(Boleta);
        return resultado;
    }



    // get R
    @GetMapping("/Boleta")
    public List<Boleta> getAllBoletas(){
        return BoletaRepository.getAll();
    }
    //get by
    @GetMapping("/Boleta/{id}")
    public List<Boleta> getCategoria(@PathVariable int id){
        return BoletaRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Boleta/{precio}") //{id}(?)
    @ResponseBody
    public String updateBoleta(@RequestBody Boleta Boleta, @PathVariable int id){
        String retorno = BoletaRepository.update(Boleta,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Boleta/{id}")
    public void borrar(@PathVariable int id){
        BoletaRepository.delete(id);
    }
}