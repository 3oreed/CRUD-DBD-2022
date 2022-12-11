package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Empresa;
import dbd.LAB.crud.repositories.EmpresaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController

public class EmpresaService implements EmpresaRepository{

    private final EmpresaRepository EmpresaRepository ;

    EmpresaService(@Lazy EmpresaRepository empresaRepository) {
        this.EmpresaRepository = empresaRepository;
    }


    @PostMapping("/Empresa")
    @ResponseBody
    public Empresa crear(@RequestBody Empresa empresa){
        Empresa resultado = EmpresaRepository.crear(empresa);
        return resultado;
    }


    @GetMapping("/Empresa")
    public List<Empresa> getAll(){
        return EmpresaRepository.getAll();
    }


    @GetMapping("/Empresa/{id_empresa}")
    public List<Empresa> showLugar(@PathVariable int id_empresa){
        return EmpresaRepository.showLugar(id_empresa);
    }


    @PutMapping("/Empresa/{id_empresa}") //{id}(?)
    @ResponseBody
    public String updatePass(@RequestBody Empresa empresa, @PathVariable int id_empresa){
        String retorno = EmpresaRepository.updatePass(empresa,id_empresa);
        return retorno;
    }


    @PutMapping("/Empresas/{id_empresa}") //{id}(?)
    @ResponseBody
    public String updateMail(@RequestBody Empresa empresa, @PathVariable int id_empresa){
        String retorno = EmpresaRepository.updateMail(empresa,id_empresa);
        return retorno;
    }


    @DeleteMapping("/Empresa/{id_empresa}")
    public void delete(@PathVariable int id_empresa){
        EmpresaRepository.delete(id_empresa);
    }
}
