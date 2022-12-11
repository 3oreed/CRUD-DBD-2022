package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Tienda;
import dbd.LAB.crud.repositories.TiendaRepository;

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

public class TiendaService implements TiendaRepository{

    private final TiendaRepository tiendaRepository;

    TiendaService(@Lazy TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }



    @PostMapping("/Tienda")
    @ResponseBody
    public Tienda crear(@RequestBody Tienda tienda) {
        Tienda resultado = tiendaRepository.crear(tienda);
        return resultado;
    }


    @PutMapping("/Tienda/{id_tienda}")
    @ResponseBody
    public String updateNombre(@RequestBody Tienda tienda, @PathVariable int id_tienda) {
        String retorno = tiendaRepository.updateNombre(tienda,id_tienda);
        return retorno;
    }


    @GetMapping("/Tienda")
    public List<Tienda> getAll() {
        return tiendaRepository.getAll();
    }


    @GetMapping("/Tienda/{id_tienda}")
    public List<Tienda> show(@PathVariable int id_tienda) {
        return tiendaRepository.show(id_tienda);
    }


    @DeleteMapping("/Tienda/{id_tienda}")
    public void delete(@PathVariable int id_tienda) {
        tiendaRepository.delete(id_tienda);

    }
}
