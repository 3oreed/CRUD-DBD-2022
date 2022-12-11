
package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class CarritoImp implements CarritoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Carrito crear(Carrito Carrito) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO carrito(cantidad_productos,subtotal)" +
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
    public String update(Carrito Carrito, int id_carrito) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update carrito set cantidad_productos=:cantidad_productos WHERE id_carrito=:id_carrito";
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
            return conn.createQuery("SELECT * from carrito order by id_carrito asc")
                    .executeAndFetch(Carrito.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Carrito> show(int id_carrito) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from carrito where id_carrito = :id_carrito ")
                    .addParameter("id_carrito",id_carrito)
                    .executeAndFetch(Carrito.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_carrito) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from carrito where id_carrito = :id_carrito")
                    .addParameter("id_carrito",id_carrito)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



