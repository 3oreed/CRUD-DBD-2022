package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Empresa_Administrador;
import dbd.LAB.crud.repositories.Empresa_administradorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class Empresa_administradorService {

    private final Empresa_administradorRepository empresaAdministradorRepository;

    public Empresa_administradorService(Empresa_administradorRepository empresaAdministradorRepository) {
        this.empresaAdministradorRepository = empresaAdministradorRepository;
    }
    @PostMapping("/Empresa_administrador")
    @ResponseBody
    public Empresa_Administrador crear(Empresa_Administrador empresaAdministrador){
        Empresa_Administrador resultado = empresaAdministradorRepository.crear(empresaAdministrador);
        return resultado;
    }
    @GetMapping("/Empresa_administrador")
    public List<Empresa_Administrador> getAllEmpresaAdmin(){
        return empresaAdministradorRepository.getAll();
    }
    @GetMapping("/Empresa_administrador/{id}")
    public List<Empresa_Administrador> getEmpresaAdmin(int id_empresa_administrador){
        return empresaAdministradorRepository.show(id_empresa_administrador);
    }
    @PutMapping("/Empresa_administrador/{precio}") //{id}(?)
    @ResponseBody
    public String updateEmpresa_admin(Empresa_Administrador empresaAdministrador,int id_empresa_administrador){
        String retorno = empresaAdministradorRepository.update(empresaAdministrador,id_empresa_administrador);
        return retorno;
    }
    @DeleteMapping("/Empresa_administrador/{id}")
    public void borrar(int id_empresa_administrador){
        empresaAdministradorRepository.delete(id_empresa_administrador);
    }
}
