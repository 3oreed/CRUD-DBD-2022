package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Administrador_Categoria_Empresa;
import dbd.LAB.crud.repositories.Administrador_Categoria_EmpresaRepository;


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
public class Administrador_Categoria_EmpresaService {
    private final Administrador_Categoria_EmpresaRepository Administrador_Categoria_EmpresaRepository;

    Administrador_Categoria_EmpresaService(Administrador_Categoria_EmpresaRepository Administrador_Categoria_EmpresaRepository){
        this.Administrador_Categoria_EmpresaRepository = Administrador_Categoria_EmpresaRepository;
    }

    // crear C
    @PostMapping("/Administrador_Categoria_Empresa")
    @ResponseBody
    public Administrador_Categoria_Empresa crear(@RequestBody Administrador_Categoria_Empresa Administrador_Categoria_Empresa){
        Administrador_Categoria_Empresa resultado = Administrador_Categoria_EmpresaRepository.crear(Administrador_Categoria_Empresa);
        return resultado;
    }



    // get R
    @GetMapping("/Administrador_Categoria_Empresa")
    public List<Administrador_Categoria_Empresa> getAllAdministrador_Categoria_Empresas(){
        return Administrador_Categoria_EmpresaRepository.getAll();
    }
    //get by
    @GetMapping("/Administrador_Categoria_Empresa/{id}")
    public List<Administrador_Categoria_Empresa> getCategoria(@PathVariable int id){
        return Administrador_Categoria_EmpresaRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Categoria/{precio}") //{id}(?)
    @ResponseBody
    public String updateAdministrador_Categoria_Empresa(@RequestBody Administrador_Categoria_Empresa Administrador_Categoria_Empresa, @PathVariable int id){
        String retorno = Administrador_Categoria_EmpresaRepository.update(Administrador_Categoria_Empresa,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Categoria/{id}")
    public void borrar(@PathVariable int id){
        Administrador_Categoria_EmpresaRepository.delete(id);
    }
}
