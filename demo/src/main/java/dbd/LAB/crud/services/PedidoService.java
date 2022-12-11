package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Pedido;
import dbd.LAB.crud.repositories.PedidoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    PedidoService(@Lazy PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    @PostMapping("/Pedido")
    @ResponseBody
    public Pedido crear(@RequestBody Pedido pedido){
        Pedido resultado = pedidoRepository.crear(pedido);
        return resultado;
    }


    @GetMapping("/Pedido/{id_pedido}")
    public List<Pedido> getPedido(@PathVariable int id_pedido){
        return pedidoRepository.getAll();
    }


    @GetMapping("/Pedido")
    public List<Pedido> getAllPedido(){
        return pedidoRepository.getAll();
    }


    @PutMapping("/Pedido/{id_pedido}") //{id}(?)
    @ResponseBody
    public String updatePedido(@RequestBody Pedido pedido,int id_pedido){
        String retorno = pedidoRepository.updateEntrega(pedido,id_pedido);
        return retorno;

    }


    @PutMapping("/Pedido/Ubicacion/{id_pedido}") //{id}(?)
    @ResponseBody
    public String updateUbicacionPedido(@RequestBody Pedido pedido,int id_pedido) {
        String retorno = pedidoRepository.updateUbicacion(pedido, id_pedido);
        return retorno;

    }
    @DeleteMapping("/Pedido/{id_pedido}")
    public void borrar(@PathVariable int id_pedido){
        pedidoRepository.delete(id_pedido);
    }
}
