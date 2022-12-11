package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Categoria;
import dbd.LAB.crud.repositories.CategoriaRepository;


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
public class CategoriaService implements CategoriaRepository{
    private final CategoriaRepository CategoriaRepository;

    CategoriaService(CategoriaRepository CategoriaRepository){
        this.CategoriaRepository = CategoriaRepository;
    }

    // crear C
    @PostMapping("/Categoria")
    @ResponseBody
    public Categoria crear(@RequestBody Categoria Categoria){
        Categoria resultado = CategoriaRepository.crear(Categoria);
        return resultado;
    }

    @Override
    @PutMapping("/Categoria/{precio}") //{id}(?)
    @ResponseBody
    public String update(Categoria categoria, int id_categoria) {
        String retorno = CategoriaRepository.update(categoria,id_categoria);
        return retorno;
    }

    @Override
    public String updateDesc(Categoria categoria, int id_categoria) {
        String retorno = CategoriaRepository.updateDesc(categoria,id_categoria);
        return retorno;
    }

    @Override
    @GetMapping("/Categoria")
    public List<Categoria> getAll() {
        return CategoriaRepository.getAll();
    }

    @Override
    @GetMapping("/Categoria/{id}")
    public List<Categoria> show(@PathVariable int id_categoria) {
        return CategoriaRepository.show(id_categoria);
    }

    @Override
    @DeleteMapping()
    public void delete(@PathVariable int id_categoria) {
        CategoriaRepository.delete(id_categoria);

    }



    @DeleteMapping("/Categoria/{id}")
    public void borrar(@PathVariable int id){
        CategoriaRepository.delete(id);
    }
}
