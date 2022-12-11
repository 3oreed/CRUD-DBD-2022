package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Pedido;
import dbd.LAB.crud.repositories.PedidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    @PostMapping("/Pedido")
    @ResponseBody
    public Pedido crear(@RequestBody Pedido pedido){
        Pedido resultado = pedidoRepository.crear(pedido);
        return resultado;
    }


    @GetMapping("/Pedido/{id}")
    public List<Pedido> getPedido(@PathVariable int id_pedido){
        return pedidoRepository.getAll();
    }


    @GetMapping("/Pedido")
    public List<Pedido> getAllPedido(){
        return pedidoRepository.getAll();
    }


    @PutMapping("/Pedido/{precio}") //{id}(?)
    @ResponseBody
    public String updateEntregaPedido(@RequestBody Pedido pedido,int id_pedido){
        String retorno = pedidoRepository.updateEntrega(pedido,id_pedido);
        return retorno;

    }


    @PutMapping("/Pedido/{precio}") //{id}(?)
    @ResponseBody
    public String updateUbicacionPedido(@RequestBody Pedido pedido,int id_pedido){
        String retorno = pedidoRepository.updateUbicacion(pedido,id_pedido);
        return retorno;

    }
    @DeleteMapping("/Pedido/{id}")
    public void borrar(@PathVariable int id_pedido){
        pedidoRepository.delete(id_pedido);
    }
}
