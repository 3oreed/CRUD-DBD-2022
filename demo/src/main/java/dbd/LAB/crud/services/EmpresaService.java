package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Empresa;
import dbd.LAB.crud.repositories.EmpresaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController

public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }


    @PostMapping("/Empresa")
    @ResponseBody
    public Empresa crear(@RequestBody Empresa empresa){
        Empresa resultado = empresaRepository.crear(empresa);
        return resultado;
    }


    @GetMapping("/Empresa")
    public List<Empresa> getAllEmpresa(){
        return empresaRepository.getAll();
    }


    @GetMapping("/Empresa/{id}")
    public List<Empresa> getEmpresa(@RequestBody int id_empresa){
        return empresaRepository.showLugar(id_empresa);
    }


    @PutMapping("/Empresa/{precio}") //{id}(?)
    @ResponseBody
    public String updatePassEmpresa(@RequestBody Empresa empresa,int id_empresa){
        String retorno = empresaRepository.updatePass(empresa,id_empresa);
        return retorno;
    }


    @PutMapping("/Empresa/{precio}") //{id}(?)
    @ResponseBody
    public String updateMailEmpresa(@RequestBody Empresa empresa, int id_empresa){
        String retorno = empresaRepository.updateMail(empresa,id_empresa);
        return retorno;
    }


    @DeleteMapping("/Empresa/{id}")
    public void borrar(@PathVariable int id_empresa){
        empresaRepository.delete(id_empresa);
    }
}
