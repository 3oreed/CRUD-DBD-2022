package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Pedido;

import java.util.List;

public interface PedidoRepository {

    public Pedido crear(Pedido pedido);
    public String update(Pedido pedido, int id_pedido);

    public List<Pedido> getAll();

    public List<Pedido> show(int id_pedido);

    public void delete(int id_pedido);
}
