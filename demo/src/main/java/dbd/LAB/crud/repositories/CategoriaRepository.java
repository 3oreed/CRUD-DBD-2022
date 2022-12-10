package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Categoria;

import java.util.List;

public interface CategoriaRepository {
    public Categoria crear(Categoria categoria);

    public String update(Categoria categoria, int id_categoria);
    public String updateDesc(Categoria categoria, int id_categoria);

    public List<Categoria> getAll();

    public List<Categoria> show(int id_categoria);

    public void delete(int id_categoria);
}
