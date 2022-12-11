package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;
import java.util.List;
@Repository
public class PedidoImp implements PedidoRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Pedido crear(Pedido pedido) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO pedido(subtotal,tipo_entrega," +
                    "ubicacion,id_pago,id_cliente) VALUES(:subtotal,:tipo_entrega,:ubicacion" +
                    ",:id_pago,:id_cliente)";
            conn.createQuery(sql,true)

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


    public String updateEntrega(Pedido pedido, int id_pedido) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update Pedido set tipo_entrega=:tipo_entrega WHERE id_pedido=:id_pedido";
            conn.createQuery(updateSql)
                    .addParameter("id_pedido", id_pedido)
                    .addParameter("tipo_entrega", pedido.getId_pedido())
                    .executeUpdate();
            return "Se actualizo el TIPO DE ENTREGA";

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Categoria";
        }
    }
    public String updateUbicacion(Pedido pedido, int id_pedido) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update Pedido set ubicacion=:ubicacion WHERE id_pedido=:id_pedido";
            conn.createQuery(updateSql)
                    .addParameter("id_pedido", id_pedido)
                    .addParameter("ubicacion", pedido.getUbicacion())
                    .executeUpdate();
            return "Se actualizo la UBICACION";

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Categoria";
        }
    }

    @Override
    public List<Pedido> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from pedido order by id_pedido ASC")
                    .executeAndFetch(Pedido.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Pedido> show(int id_pedido) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Pedido where id_pedido = :id_pedido")
                    .addParameter("id",id_pedido)
                    .executeAndFetch(Pedido.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_pedido) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Pedido where id_pedido = :id_pedido")
                    .addParameter("id_pedido",id_pedido)
                    .executeUpdate();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
