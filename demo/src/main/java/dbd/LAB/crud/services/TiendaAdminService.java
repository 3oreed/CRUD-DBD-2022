package dbd.LAB.crud.services;
import dbd.LAB.crud.models.TiendaAdmin;
import dbd.LAB.crud.repositories.TiendaAdminRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TiendaAdminService implements TiendaAdminRepository {

    private final TiendaAdminRepository tiendaAdminRepository;

    public TiendaAdminService(@Lazy TiendaAdminRepository tiendaAdminRepository) {
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
    public String update(@PathVariable TiendaAdmin tiendaAdmin,@PathVariable int id_tienda_admin) {
        String retorno = tiendaAdminRepository.update(tiendaAdmin,id_tienda_admin);
        return retorno;
    }

    @Override
    @GetMapping("/TiendaAdmin")
    public List<TiendaAdmin> getAll() {
        return tiendaAdminRepository.getAll();
    }

    @Override
    @GetMapping("/TiendaAdmin/{id_tienda_admin}")
    public List<TiendaAdmin> show(@PathVariable int id_tienda_admin) {
        return tiendaAdminRepository.show(id_tienda_admin);
    }

    @Override
    @DeleteMapping("/TiendaAdmin")
    public void delete(@PathVariable int id_tienda_admin) {
        tiendaAdminRepository.delete(id_tienda_admin);

    }
}
