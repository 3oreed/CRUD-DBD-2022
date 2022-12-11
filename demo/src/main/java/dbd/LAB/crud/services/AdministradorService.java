package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Administrador;
import dbd.LAB.crud.repositories.AdministradorRepository;


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
public class AdministradorService {
    private final AdministradorRepository AdministradorRepository;

    AdministradorService(AdministradorRepository AdministradorRepository){
        this.AdministradorRepository = AdministradorRepository;
    }

    // crear C
    @PostMapping("/Administrador")
    @ResponseBody
    public Administrador crear(@RequestBody Administrador Administrador){
        Administrador resultado = AdministradorRepository.crear(Administrador);
        return resultado;
    }


    // get R
    @GetMapping("/Administrador")
    public List<Administrador> getAllAdministradors(){
        return AdministradorRepository.getAll();
    }
    //get by
    @GetMapping("/Administrador/{id}")
    public List<Administrador> getCategoria(@PathVariable int id){
        return AdministradorRepository.show(id);
    }

    // actualizar U
    @PutMapping("/Administrador/{id}") //{id}(?)
    @ResponseBody
    public String updateAdministrador(@RequestBody Administrador Administrador, @PathVariable int id){
        String retorno = AdministradorRepository.update(Administrador,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Administrador/{id}")
    public void borrar(@PathVariable int id){
        AdministradorRepository.delete(id);
    }
}
