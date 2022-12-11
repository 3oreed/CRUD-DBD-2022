package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Empresa;
import dbd.LAB.crud.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class EmpresaImp implements EmpresaRepository{
    @Autowired
    private Sql2o sql2o;

    public Empresa crear(Empresa empresa) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO empresa(clave,mail,direccion,id_ranking)"
                    + "VALUES (:clave,:mail,:direccion,:id_ranking)";
            conn.createQuery(sql,true)
                    .throwOnMappingFailure(false)
                    .addParameter("clave",empresa.getClave())
                    .addParameter("mail",empresa.getMail())
                    .addParameter("direccion",empresa.getDireccion())
                    .addParameter("id_ranking",empresa.getId_ranking())
                    .executeUpdate();
            return empresa;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;

    }

    public String updatePass(Empresa empresa, int id_empresa) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update empresa set clave=:clave WHERE id_empresa=:id_empresa";
            conn.createQuery(updateSql)
                    .addParameter("id_empresa",id_empresa)
                    .addParameter("clave",empresa.getClave())
                    .executeUpdate();
            return "Se actualizó la clave de empresa.";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar clave de empresa";
        }


    }
    public String updateMail(Empresa empresa, int id_empresa) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update empresa set mail=:mail WHERE id_empresa=:id_empresa";
            conn.createQuery(updateSql)
                    .addParameter("id_empresa",id_empresa)
                    .addParameter("mail",empresa.getMail())
                    .executeUpdate();
            return "Se actualizó mail de empresa";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar mail de empresa";
        }


    }

    public List<Empresa> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from empresa order by id_empresa asc")
                    //.throwOnMappingFailure(false)
                    .executeAndFetch(Empresa.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Empresa> show(int id_empresa) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from empresa where id_empresa = :id_empresa ")
                    .addParameter("id_empresa",id_empresa)
                    .executeAndFetch(Empresa.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void delete(int id_empresa) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from empresa where id_empresa = :id_empresa")
                    .addParameter("id_empresa",id_empresa)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
