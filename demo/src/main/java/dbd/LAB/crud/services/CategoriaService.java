package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Categoria;
import dbd.LAB.crud.repositories.CategoriaRepository;


import org.springframework.context.annotation.Lazy;
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
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(@Lazy CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    // crear C
    @PostMapping("/Categoria")
    @ResponseBody
    public Categoria crear(@RequestBody Categoria categoria){
        Categoria resultado = categoriaRepository.crear(categoria);
        return resultado;
    }

    @Override
    @PutMapping("/Categoria/{id_categoria}") //{id}(?)
    @ResponseBody
    public String update(@RequestBody Categoria categoria,@PathVariable int id_categoria) {
        String retorno = categoriaRepository.update(categoria,id_categoria);
        return retorno;
    }

    @Override
    public String updateDesc(@RequestBody Categoria categoria,@PathVariable int id_categoria) {
        String retorno = categoriaRepository.updateDesc(categoria,id_categoria);
        return retorno;
    }

    @Override
    @GetMapping("/Categoria")
    public List<Categoria> getAll() {
        return categoriaRepository.getAll();
    }

    @Override
    @GetMapping("/Categoria/{id_categoria}")
    public List<Categoria> show(@PathVariable int id_categoria) {
        return categoriaRepository.show(id_categoria);
    }

    @Override
    @DeleteMapping("/Categoria/{id_categoria}")
    public void delete(@PathVariable int id_categoria) {
        categoriaRepository.delete(id_categoria);

    }


}
