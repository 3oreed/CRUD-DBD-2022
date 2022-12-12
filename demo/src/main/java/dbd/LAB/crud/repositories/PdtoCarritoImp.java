package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.PdtoCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class PdtoCarritoImp implements PdtoCarritoRepository {
    @Autowired
    private Sql2o sql2o;

    public PdtoCarrito crear(PdtoCarrito PdtoCarrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO productocarrito (nombre,cantidad,comentario,precio,id_carrito,id_prod)" +
                    "VALUES (:nombre,:cantidad,:comentario,:precio,:id_carrito,:id_prod)";
            conn.createQuery(sql,true)
                    .addParameter("nombre",PdtoCarrito.getNombre())
                    .addParameter("cantidad",PdtoCarrito.getCantidad())
                    .addParameter("comentario",PdtoCarrito.getComentario())
                    .addParameter("precio",PdtoCarrito.getPrecio())
                    .addParameter("id_carrito",PdtoCarrito.getId_carrito())
                    .addParameter("id_prod",PdtoCarrito.getId_prod())
                    .executeUpdate();
            return PdtoCarrito;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    public String update(PdtoCarrito PdtoCarrito, int id_item_carrito) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update productocarrito set cantidad=:cantidad where id_item_carrito=:id_item_carrito";
            conn.createQuery(updateSql)
                    .addParameter("cantidad",PdtoCarrito.getCantidad())
                    .addParameter("id_item_carrito",id_item_carrito)
                    .executeUpdate();
            return "Se actualizo cantidad de un ProductoCarrito";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar cantidad de ProductoCarrito";
        }


    }


    public List<PdtoCarrito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from productocarrito order by id_carrito asc")
                    .executeAndFetch(PdtoCarrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<PdtoCarrito> show(int id_item_carrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from productocarrito where id_item_carrito = :id_item_carrito ")
                    .addParameter("id_item_carrito",id_item_carrito)
                    .executeAndFetch(PdtoCarrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void delete(int id_item_carrito) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from productocarrito where id_item_carrito = :id_item_carrito")
                    .addParameter("id_item_carrito",id_item_carrito)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
