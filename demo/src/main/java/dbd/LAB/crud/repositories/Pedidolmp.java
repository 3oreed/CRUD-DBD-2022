package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class Pedidolmp implements PedidoRepository{

    @
    private Sql2o sql2o;

    @Override
    public Pedido crear(Pedido pedido) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO pedido(id_pedido,subtotal,tipo_entrega," +
                    "ubicacion,id_pago,id_cliente) VALUES(id_pedido,subtotal,:tipo_entrega,:Ubicacion" +
                    ",id_pago_id_cliente)";
            conn.createQuery(sql,true)
                    .addColumnMapping("id_pedido", pedido.getId_pedido())
                    .addParameter("subtotal",pedido.getSubtotal())
                    .addParameter("tipo_entrega",pedido.getTipo_entrega())
                    .addParameter("ubicacion",pedido.getUbicacion())
                    .addParameter("id_pago",pedido.getId_pago())
                    .addParameter("id_cliente",pedido.getId_cliente())
                    .executeUpdate();
                    return pedido;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public String update(Pedido pedido, int id_pedido) {
        return null;
    }

    @Override
    public List<Pedido> getAll() {
        return null;
    }

    @Override
    public List<Pedido> show(int id_pedido) {
        return null;
    }

    @Override
    public void delete(int id_pedido) {

    }
}
