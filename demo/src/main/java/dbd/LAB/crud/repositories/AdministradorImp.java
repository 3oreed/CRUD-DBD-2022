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
    public Administrador crear(Administrador Administrador) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO administrador(clave,email,nombre,apellido)" +
                    "VALUES (:clave,:email, :nombre,:apellido)";
            conn.createQuery(sql, true)
                    //.addParameter("id_admin", Administrador.getId_admin())
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
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from administrador order by id_admin ASC")
                    .executeAndFetch(Administrador.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Administrador> show(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from administrador where id_admin = :id ")
                    .addParameter("id", id)
                    .executeAndFetch(Administrador.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id_admin) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE from administrador where id_admin = :id_admin ")
                    .addParameter("id_admin", id_admin)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public String update(Administrador Administrador, int id) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update administrador set nombre=:nombre WHERE id_admin=:id_admin";
            conn.createQuery(updateSql)
                    .addParameter("nombre", Administrador.getNombre())
                    .addParameter("id_admin",id)
                    .executeUpdate();
            return "Se actualizó el Administrador";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Administrador";
        }
    }
}

