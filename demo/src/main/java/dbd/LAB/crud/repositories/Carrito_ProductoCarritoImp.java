
package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Carrito_ProductoCarrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class Carrito_ProductoCarritoImp implements Carrito_ProductoCarritoRepository{
    private Sql2o sql2o;

    @Override
    public Carrito_ProductoCarrito crear(Carrito_ProductoCarrito Carrito_ProductoCarrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO pago(id_Carrito_ProductoCarrito,id_item_carrito,id_carrito)" +
                    "VALUES (:id_Carrito_ProductoCarrito,:id_item_carrito,:id_carrito)";
            conn.createQuery(sql,true)
                    .addParameter("id_Carrito_ProductoCarrito",Carrito_ProductoCarrito.getId_Carrito_ProductoCarrito())
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
    public String update(Carrito_ProductoCarrito Carrito_ProductoCarrito, int id_Carrito_ProductoCarrito) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update Carrito_ProductoCarrito set id_item_carrito=:id_item_carrito WHERE id_Carrito_ProductoCarrito=:id_Carrito_ProductoCarrito";
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
            return conn.createQuery("SELECT * from Carrito_ProductoCarrito order by id_Carrito_ProductoCarrito asc")
                    .executeAndFetch(Carrito_ProductoCarrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Carrito_ProductoCarrito> show(int id_Carrito_ProductoCarrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Carrito_ProductoCarrito where id_Carrito_ProductoCarrito = :id_Carrito_ProductoCarrito")
                    .addParameter("id_Carrito_ProductoCarrito",id_Carrito_ProductoCarrito)
                    .executeAndFetch(Carrito_ProductoCarrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_Carrito_ProductoCarrito) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Carrito_ProductoCarrito where id_Carrito_ProductoCarrito = :id_Carrito_ProductoCarrito")
                    .addParameter("id_Carrito_ProductoCarrito",id_Carrito_ProductoCarrito)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}







