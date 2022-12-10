package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Oferta;
import dbd.LAB.crud.repositories.OfertaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class OfertaService {

    private final OfertaRepository ofertaRepository;

    public OfertaService(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }
    @PostMapping("/Oferta")
    @ResponseBody
    public Oferta crear(@RequestBody Oferta oferta){
        Oferta resultado = ofertaRepository.crear(oferta);
        return resultado;
    }
    @GetMapping("/Oferta")
    public List<Oferta> getAllOferta(){
        return ofertaRepository.getAll();
    }
    @GetMapping("/Oferta/{id}")
    public  List<Oferta> getOferta(@PathVariable int id_oferta){
        return ofertaRepository.show(id_oferta);
    }
    @PutMapping("/Oferta/{precio}") //{id}(?)
    @ResponseBody
    public String updateOferta(@RequestBody Oferta oferta, int id_oferta){
        String retorno = ofertaRepository.update(oferta,id_oferta);
        return retorno;
    }
    @DeleteMapping("/Oferta/{id}")
    public void borrar(@PathVariable int id_oferta){
        ofertaRepository.delete(id_oferta);
    }
}
