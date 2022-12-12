
package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.time.LocalDate;
import java.util.List;
@Repository
public class ClienteImp implements ClienteRepository{
    @Autowired

    private Sql2o sql2o;

    @Override
    public Cliente crear(Cliente Cliente) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO cliente(nombre,apellido,clave,email,direccion,fecha_nacimiento)" +
                    "VALUES (:Nombre_cliente,:Apellido_cliente,:Clave_cliente,:email,:Direccion_cliente," +
                    ":Fecha_nacimiento_cliente)";
            conn.createQuery(sql,true)
                    .addParameter("Nombre_cliente",Cliente.getNombre())
                    .addParameter("Apellido_cliente",Cliente.getApellido())
                    .addParameter("Clave_cliente",Cliente.getClave())
                    .addParameter("email",Cliente.getEmail())
                    .addParameter("Direccion_cliente",Cliente.getDireccion())
                    .addParameter("Fecha_nacimiento_cliente",LocalDate.parse(Cliente.getFecha_nacimiento()))
                    .executeUpdate();
            return Cliente;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updatePass(Cliente cliente, int id_cliente) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update cliente set clave=:clave WHERE id_cliente=:id_cliente";
            conn.createQuery(updateSql)
                    .addParameter("clave",cliente.getClave())
                    .addParameter("id_cliente",id_cliente)
                    .executeUpdate();
            return "Se actualizó la CLAVE de cliente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar Clave de cliente";
        }

    }

    @Override
    public String updateAll(Cliente cliente, int id_cliente) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update cliente set nombre=:nombre,apellido=:apellido,clave=:clave,email=:email," +
                    "direccion=:direccion,fecha_nacimiento=:fecha_nacimiento WHERE id_cliente=:id_cliente";
            conn.createQuery(updateSql)
                    .addParameter("nombre",cliente.getNombre())
                    .addParameter("apellido",cliente.getApellido())
                    .addParameter("clave",cliente.getClave())
                    .addParameter("email",cliente.getEmail())
                    .addParameter("direccion",cliente.getDireccion())
                    .addParameter("fecha_nacimiento",LocalDate.parse(cliente.getFecha_nacimiento()))
                    .addParameter("id_cliente",id_cliente)
                    .executeUpdate();
            return "Se actualizaron DATOS de cliente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar DATOS de cliente";
        }
    }

    @Override
    public String updateDireccion(Cliente cliente, int id_cliente) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update cliente set direccion=:direccion WHERE id_cliente=:id_cliente";
            conn.createQuery(updateSql)
                    .addParameter("direccion",cliente.getDireccion())
                    .addParameter("id_cliente",id_cliente)
                    .executeUpdate();
            return "Se actualizó la DIRECCION de cliente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar DIRECCION de cliente";
        }
    }

    @Override
    public String updateMail(Cliente cliente, int id_cliente) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update cliente set email=:email WHERE id_cliente=:id_cliente";
            conn.createQuery(updateSql)
                    .addParameter("email",cliente.getEmail())
                    .addParameter("id_cliente",id_cliente)
                    .executeUpdate();
            return "Se actualizó el EMAIL de cliente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar EMAIL de cliente";
        }
    }

    @Override
    public List<Cliente> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from cliente order by id_cliente asc")
                    .executeAndFetch(Cliente.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Cliente> show(int id_cliente) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from cliente where id_cliente = :id_cliente")
                    .addParameter("id_cliente",id_cliente)
                    .executeAndFetch(Cliente.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_cliente) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from cliente where id_cliente= :id_cliente")
                    .addParameter("id_cliente",id_cliente)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



