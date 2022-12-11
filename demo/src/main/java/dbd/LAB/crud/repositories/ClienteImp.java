
package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class ClienteImp implements ClienteRepository{
    @Autowired

    private Sql2o sql2o;

    @Override
    public Cliente crear(Cliente Cliente) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Cliente(Nombre_cliente,Apellido_cliente,Clave_cliente,Direccion_cliente,Fecha_nacimiento_cliente,Edad_cliente)" +
                    "VALUES (:Nombre_cliente,:Apellido_cliente,:Clave_cliente,:Direccion_cliente,:Fecha_nacimiento_cliente,:Edad_cliente)";
            conn.createQuery(sql,true)
                     //.addParameter("id_cliente",Cliente.getId_cliente())
                    .addParameter("Nombre_cliente",Cliente.getNombre_cliente())
                    .addParameter("Apellido_cliente",Cliente.getApellido_cliente())
                    .addParameter("Clave",Cliente.getClave_cliente())
                    .addParameter("email",Cliente.getEmail_cliente())
                    .addParameter("Direccion_cliente",Cliente.getDireccion_cliente())
                    .addParameter("Fecha_nacimiento_cliente",Cliente.getFecha_nacimiento_cliente())
                    .addParameter("Edad_cliente",Cliente.getEdad_cliente())

                    .executeUpdate();
            return Cliente;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Cliente Cliente, int Id_cliente) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update Cliente set Clave_cliente=:Clave_cliente WHERE Id_cliente=:Id_cliente";
            conn.createQuery(updateSql)
                    .addParameter("Clave_cliente",Cliente.getClave_cliente())
                    .executeUpdate();
            return "Se actualizó la CLAVE de cliente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar Clave de cliente";
        }

    }

    @Override
    public List<Cliente> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from cliente order by Id_cliente asc")
                    .executeAndFetch(Cliente.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Cliente> show(int Id_cliente) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from cliente where Id_cliente = :Id_cliente")
                    .addParameter("Id_cliente",Id_cliente)
                    .executeAndFetch(Cliente.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int Id_cliente) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from cliente where Id_cliente= :Id_cliente")
                    .addParameter("Id_cliente",Id_cliente)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



