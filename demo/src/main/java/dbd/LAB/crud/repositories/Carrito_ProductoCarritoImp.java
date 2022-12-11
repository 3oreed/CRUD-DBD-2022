
package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Carrito_ProductoCarrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class Carrito_ProductoCarritoImp implements Carrito_ProductoCarritoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Carrito_ProductoCarrito crear(Carrito_ProductoCarrito Carrito_ProductoCarrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO carrito_productocarrito(id_item_carrito,id_carrito)" +
                    "VALUES (:id_item_carrito,:id_carrito)";
            conn.createQuery(sql,true)
                    //.addParameter("id_Carrito_ProductoCarrito",Carrito_ProductoCarrito.getId_Carrito_ProductoCarrito())
                    .addParameter("id_item_carrito",Carrito_ProductoCarrito.getId_item_carrito())
                    .addParameter("id_carrito",Carrito_ProductoCarrito.getId_carrito())
                    .executeUpdate();
            return Carrito_ProductoCarrito;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Carrito_ProductoCarrito Carrito_ProductoCarrito, int id_carrito_productocarrito) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update carrito_productocarrito set id_item_carrito=:id_item_carrito WHERE id_carrito_productocarrito=:id_carrito_productocarrito";
            conn.createQuery(updateSql)
                    .addParameter("id_item_carrito",Carrito_ProductoCarrito.getId_item_carrito())
                    .executeUpdate();
            return "Se actualizó el id_item_carrito";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar id_item_carrito";
        }

    }

    @Override
    public List<Carrito_ProductoCarrito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from carrito_productocarrito order by id_carrito_productocarrito asc")
                    .executeAndFetch(Carrito_ProductoCarrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Carrito_ProductoCarrito> show(int id_carrito_productocarrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from carrito_productocarrito where id_carrito_productocarrito = :id_carrito_productocarrito")
                    .addParameter("id_Carrito_ProductoCarrito",id_carrito_productocarrito)
                    .executeAndFetch(Carrito_ProductoCarrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_carrito_productocarrito) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from carrito_productocarrito where id_carrito_productocarrito = :id_carrito_productocarrito")
                    .addParameter("id_Carrito_ProductoCarrito",id_carrito_productocarrito)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}







