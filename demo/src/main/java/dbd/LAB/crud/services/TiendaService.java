package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Pedido;
import dbd.LAB.crud.models.Tienda;
import dbd.LAB.crud.repositories.TiendaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class TiendaService implements TiendaRepository{

    private final TiendaRepository tiendaRepository;

    TiendaService(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }
    @PostMapping("/Tienda")
    @ResponseBody
    @Override
    public Tienda crear(@RequestBody Tienda tienda) {
        Tienda resultado = tiendaRepository.crear(tienda);
        return resultado;
    }

    @Override
    @PutMapping("/Tienda/{id_tienda}")
    public String updateNombre(Tienda tienda, int id_tienda) {
        String retorno = tiendaRepository.updateNombre(tienda,id_tienda);
        return retorno;
    }

    @Override
    @GetMapping("/Tienda")
    public List<Tienda> getAll() {
        return tiendaRepository.getAll();
    }

    @Override
    @GetMapping("/Tienda/{id_tienda}")
    public List<Tienda> show(int id_tienda) {
        return tiendaRepository.show(id_tienda);
    }

    @Override
    @DeleteMapping("/Tienda")
    public void delete(int id_tienda) {
        tiendaRepository.delete(id_tienda);

    }
}
