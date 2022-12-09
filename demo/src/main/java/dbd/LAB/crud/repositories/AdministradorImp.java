package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class AdministradorImp implements AdministradorRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public  Administrador crear(Administrador Administrador){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Administrador (id_admin,clave,email,nombre,apellido)" +
                    "VALUES (id,:clave,:email, :nombre,:apellido)";
            conn.createQuery(sql, true)
                    .addColumnMapping("id_admin", Administrador.getId_admin())
                    .addParameter("clave", Administrador.getClave())
                    .addParameter("email", Administrador.getEmail())
                    .addParameter("nombre", Administrador.getNombre())
                    .addParameter("apellido", Administrador.getApellido())

                    .executeUpdate();
            return Administrador;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }



    @Override
    public List<Administrador> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Administrador order by nombre ASC")
                    .executeAndFetch(Administrador.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Administrador> show(String id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Administrador where id = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Administrador.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }




    @Override
    public void delete(String id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Administrador where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public String update(Administrador Administrador, String id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Administrador set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("nombre", Administrador.getNombre())
                    .executeUpdate();
            return "Se actualizó el Administrador;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Administrador";
        }
    }


