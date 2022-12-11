package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Empresa_Administrador;
import dbd.LAB.crud.repositories.Empresa_administradorRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class Empresa_administradorService {

    private final Empresa_administradorRepository empresaAdministradorRepository;

    public Empresa_administradorService(@Lazy Empresa_administradorRepository empresaAdministradorRepository) {
        this.empresaAdministradorRepository = empresaAdministradorRepository;
    }
    @PostMapping("/Empresa_Administrador")
    @ResponseBody
    public Empresa_Administrador crear(@RequestBody Empresa_Administrador empresaAdministrador){
        Empresa_Administrador resultado = empresaAdministradorRepository.crear(empresaAdministrador);
        return resultado;
    }
    @GetMapping("/Empresa_Administrador")
    public List<Empresa_Administrador> getAllEmpresaAdmin(){
        return empresaAdministradorRepository.getAll();
    }
    @GetMapping("/Empresa_Administrador/{id_empresa_administrador}")
    public List<Empresa_Administrador> getEmpresaAdmin(@PathVariable int id_empresa_administrador){
        return empresaAdministradorRepository.show(id_empresa_administrador);
    }
    @PutMapping("/Empresa_Administrador/{id_empresa_administrador}") //{id}(?)
    @ResponseBody
    public String updateEmpresa_admin(@RequestBody Empresa_Administrador empresaAdministrador,@PathVariable int id_empresa_administrador){
        String retorno = empresaAdministradorRepository.update(empresaAdministrador,id_empresa_administrador);
        return retorno;
    }
    @DeleteMapping("/Empresa_Administrador/{id_empresa_administrador}")
    public void borrar(@PathVariable int id_empresa_administrador){
        empresaAdministradorRepository.delete(id_empresa_administrador);
    }
}
