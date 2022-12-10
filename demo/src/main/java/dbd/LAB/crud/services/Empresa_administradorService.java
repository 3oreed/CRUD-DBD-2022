package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Empresa_Administrador;
import dbd.LAB.crud.repositories.Empresa_administradorRepository;

import java.util.List;

public class Empresa_administradorService {

    private final Empresa_administradorRepository empresaAdministradorRepository;

    public Empresa_administradorService(Empresa_administradorRepository empresaAdministradorRepository) {
        this.empresaAdministradorRepository = empresaAdministradorRepository;
    }

    public Empresa_Administrador crear(Empresa_Administrador empresaAdministrador){
        Empresa_Administrador resultado = empresaAdministradorRepository.crear(empresaAdministrador);
        return resultado;
    }

    public List<Empresa_Administrador> getAllEmpresaAdmin(){
        return empresaAdministradorRepository.getAll();
    }

    public List<Empresa_Administrador> getEmpresaAdmin(int id_empresa_administrador){
        return empresaAdministradorRepository.show(id_empresa_administrador);
    }

    public String updateEmpresa_admin(Empresa_Administrador empresaAdministrador,int id_empresa_administrador){
        String retorno = empresaAdministradorRepository.update(empresaAdministrador,id_empresa_administrador);
        return retorno;
    }

    public void borrar(int id_empresa_administrador){
        empresaAdministradorRepository.delete(id_empresa_administrador);
    }
}
