package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.ProductoCarrito;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class ProductoCarritoImp implements ProductoCarritoRepository{
    private Sql2o sql2o;

    @Override
    public ProductoCarrito crear(ProductoCarrito prodCarrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO productocarrito (nombre,cantidad,comentario)" +
                    "VALUES (:nombre,:cantidad,comentario)";
            conn.createQuery(sql,true)
                    .addParameter("nombre",prodCarrito.getNombreItem())
                    .addParameter("cantidad",prodCarrito.getCantItem())
                    .addParameter("comentario",prodCarrito.getComentario())
                    .executeUpdate();
            return prodCarrito;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(ProductoCarrito prodCarrito, int id_item_carrito) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update productocarrito set cantidad=:cantidad where id_item_carrito=:id_item_carrito";
            conn.createQuery(updateSql)
                    .addParameter("cantidad",prodCarrito.getCantItem())
                    .executeUpdate();
            return "Se actualizo cantidad de un ProductoCarrito";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar cantidad de ProductoCarrito";
        }

    }

    @Override
    public List<ProductoCarrito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from productocarrito order by id_item_carrito asc ")
                    .executeAndFetch(ProductoCarrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductoCarrito> show(int id_item_carrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from productocarrito where id_item_carrito=:id_item_carrito ")
                    .addParameter("id_item_carrito ",id_item_carrito)
                    .executeAndFetch(ProductoCarrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_item_carrito) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from productocarrito where id_item_carrito=:id_item_carrito")
                    .addParameter("id_item_carrito",id_item_carrito)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
