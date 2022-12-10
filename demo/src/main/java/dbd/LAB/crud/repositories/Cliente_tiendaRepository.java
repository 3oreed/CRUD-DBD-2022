package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Cliente_tienda;

import java.util.List;

public interface Cliente_tiendaRepository {
    public Cliente_tienda crear(Cliente_tienda clienteTienda);

    public String update(Cliente_tienda clienteTienda, int id_cliente_tienda);

    public List<Cliente_tienda> getAll();

    public List<Cliente_tienda> show(int id_cliente_tienda);

    public void delete(int id_cliente_tienda);
}
