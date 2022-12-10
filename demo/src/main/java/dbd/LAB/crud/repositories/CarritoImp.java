
package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class CarritoImp implements CarritoRepository{
    private Sql2o sql2o;

    @Override
    public Carrito crear(Carrito Carrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO pago(id_Carrito,cantidad_productos,subtotal)" +
                    "VALUES (:cantidad_productos,:subtotal)";
            conn.createQuery(sql,true)
                    //.addParameter("id_Carrito",Carrito.getId_Carrito())
                    .addParameter("cantidad_productos",Carrito.getCantidad_productos())
                    .addParameter("subtotal",Carrito.getSubtotal())
                    .executeUpdate();
            return Carrito;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Carrito Carrito, int id_Carrito) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update Carrito set cantidad_productos=:cantidad_productos WHERE id_Carrito=:id_Carrito";
            conn.createQuery(updateSql)
                    .addParameter("cantidad_productos",Carrito.getCantidad_productos())
                    .executeUpdate();
            return "Se actualizó el Cantidad_productos";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar Cantidad_productos";
        }

    }

    @Override
    public List<Carrito> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from Carrito order by id_Carrito asc")
                    .executeAndFetch(Carrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Carrito> show(int id_Carrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Carrito where id_Carrito = :id_Carrito ")
                    .addParameter("id_Carrito",id_Carrito)
                    .executeAndFetch(Carrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_Carrito) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Carrito where id_Carrito = :id_Carrito")
                    .addParameter("id_Carrito",id_Carrito)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



