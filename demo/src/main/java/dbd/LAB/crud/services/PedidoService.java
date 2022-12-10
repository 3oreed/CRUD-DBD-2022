package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Pedido;
import dbd.LAB.crud.repositories.PedidoRepository;
import java.util.List;

public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }



    public Pedido crear(Pedido pedido){
        Pedido resultado = pedidoRepository.crear(pedido);
        return resultado;
    }

    public List<Pedido> getPedido(int id_pedido){
        return pedidoRepository.getAll();
    }

    public List<Pedido> getAllPedido(){
        return pedidoRepository.getAll();

    }

    public String updateEntregaPedido(Pedido pedido,int id_pedido){
        String retorno = pedidoRepository.updateEntrega(pedido,id_pedido);
        return retorno;

    }
    public String updateUbicacionPedido(Pedido pedido,int id_pedido){
        String retorno = pedidoRepository.updateUbicacion(pedido,id_pedido);
        return retorno;

    }

    public void borrar(int id_pedido){
        pedidoRepository.delete(id_pedido);
    }
}
