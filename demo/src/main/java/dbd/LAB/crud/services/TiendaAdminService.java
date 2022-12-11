package dbd.LAB.crud.services;
import dbd.LAB.crud.models.TiendaAdmin;
import dbd.LAB.crud.repositories.TiendaAdminRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
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
public class TiendaAdminService  {

    private final TiendaAdminRepository tiendaAdminRepository;

    public TiendaAdminService(@Lazy TiendaAdminRepository tiendaAdminRepository) {
        this.tiendaAdminRepository = tiendaAdminRepository;
    }


    @PostMapping("/TiendaAdmin")
    @ResponseBody
    public TiendaAdmin crear(@RequestBody TiendaAdmin tiendaAdmin) {
        TiendaAdmin resultado = tiendaAdminRepository.crear(tiendaAdmin);
        return resultado;
    }


    @PutMapping("/TiendaAdmin/{id_tienda_admin}")
    @ResponseBody
    public String update(@PathVariable TiendaAdmin tiendaAdmin,@PathVariable int id_tienda_admin) {
        String retorno = tiendaAdminRepository.update(tiendaAdmin,id_tienda_admin);
        return retorno;
    }

    @GetMapping("/TiendaAdmin")
    public List<TiendaAdmin> getAll() {
        return tiendaAdminRepository.getAll();
    }


    @GetMapping("/TiendaAdmin/{id_tienda_admin}")
    public List<TiendaAdmin> show(@PathVariable int id_tienda_admin) {
        return tiendaAdminRepository.show(id_tienda_admin);
    }


    @DeleteMapping("/TiendaAdmin/{id_tienda_admin}")
    public void delete(@PathVariable int id_tienda_admin) {
        tiendaAdminRepository.delete(id_tienda_admin);

    }
}
