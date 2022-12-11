package dbd.LAB.crud.repositories;


import dbd.LAB.crud.models.ProductoCategoria;

import java.util.List;

public interface ProductoCategoriaRepository {
    public ProductoCategoria crear(ProductoCategoria ProductoCat);

    public String update(ProductoCategoria ProductoCat, int idProdCat);

    public List <ProductoCategoria> verificaStock(int idProdCat);

    public List<ProductoCategoria> getAll();

    public List<ProductoCategoria> show(int idProdCat);

    public void delete(int idProdCat);
}
