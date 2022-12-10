package dbd.LAB.crud.services;
import dbd.LAB.crud.repositories.CategoriaImp;
import dbd.LAB.crud.repositories.CategoriaRepository;
import dbd.LAB.crud.models.Categoria;

import java.util.List;

public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria crear(Categoria categoria){
        Categoria resultado = categoriaRepository.crear(categoria);
        return resultado;
    }

    public List<Categoria> getAllCategoria(){
        return categoriaRepository.getAll();
    }

    public List<Categoria> getCategoria(int id_categoria){
        return categoriaRepository.show(id_categoria);

    }

    public String updateCategoria(Categoria categoria,int id_categoria){
        String retorno = categoriaRepository.update(categoria,id_categoria);
        return retorno;
    }

    public String UpdateDescCategoria(Categoria categoria,int id_categoria){
        String retorno = categoriaRepository.updateDesc(categoria,id_categoria);
        return retorno;
    }

    public void borrar(int id_categoria){
        categoriaRepository.delete(id_categoria);
    }
}
