package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Cliente_ProductoCategoria;

import java.util.List;

public interface Cliente_ProductoCategoriaRepository {
    public Cliente_ProductoCategoria crear(Cliente_ProductoCategoria Cliente_ProductoCategoria);

    public String update(Cliente_ProductoCategoria Cliente_ProductoCategoria, int id_Cliente_ProductoCategoria);

    public List<Cliente_ProductoCategoria> getAll();

    public List<Cliente_ProductoCategoria> show(int id_Cliente_ProductoCategoria);

    public void delete(int id_Cliente_ProductoCategoria);
}
