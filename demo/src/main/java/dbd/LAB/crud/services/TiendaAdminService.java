package dbd.LAB.crud.services;
import dbd.LAB.crud.models.TiendaAdmin;
import dbd.LAB.crud.repositories.TiendaAdminRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TiendaAdminService implements TiendaAdminRepository {

    private final TiendaAdminRepository tiendaAdminRepository;

    public TiendaAdminService(TiendaAdminRepository tiendaAdminRepository) {
        this.tiendaAdminRepository = tiendaAdminRepository;
    }

    @Override
    @PostMapping("/TiendaAdmin")
    public TiendaAdmin crear(@RequestBody TiendaAdmin tiendaAdmin) {
        TiendaAdmin resultado = tiendaAdminRepository.crear(tiendaAdmin);
        return resultado;
    }

    @Override
    @PutMapping("/TiendaAdmin")
    public String update(TiendaAdmin tiendaAdmin, int id_TiendaAdmin) {
        String retorno = tiendaAdminRepository.update(tiendaAdmin,id_TiendaAdmin);
        return retorno;
    }

    @Override
    @GetMapping("/TiendaAdmin")
    public List<TiendaAdmin> getAll() {
        return tiendaAdminRepository.getAll();
    }

    @Override
    @GetMapping("/TiendaAdmin/{id_TiendaAdmin}")
    public List<TiendaAdmin> show(int id_TiendaAdmin) {
        return tiendaAdminRepository.show(id_TiendaAdmin);
    }

    @Override
    @DeleteMapping("/TiendaAdmin")
    public void delete(int id_TiendaAdmin) {
        tiendaAdminRepository.delete(id_TiendaAdmin);

    }
}
