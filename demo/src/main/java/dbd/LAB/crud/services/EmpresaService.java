package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Empresa;
import dbd.LAB.crud.repositories.EmpresaRepository;

import java.util.List;

public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa crear(Empresa empresa){
        Empresa resultado = empresaRepository.crear(empresa);
        return resultado;
    }

    public List<Empresa> getAllEmpresa(){
        return empresaRepository.getAll();
    }

    public List<Empresa> getEmpresa(int id_empresa){
        return empresaRepository.showLugar(id_empresa);
    }

    public String updatePassEmpresa(Empresa empresa,int id_empresa){
        String retorno = empresaRepository.updatePass(empresa,id_empresa);
        return retorno;
    }

    public String updateMailEmpresa(Empresa empresa, int id_empresa){
        String retorno = empresaRepository.updateMail(empresa,id_empresa);
        return retorno;
    }

    public void borrar(int id_empresa){
        empresaRepository.delete(id_empresa);
    }
}
