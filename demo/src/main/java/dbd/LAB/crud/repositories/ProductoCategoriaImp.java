package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Empresa_Administrador;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class ProductoCategoriaImp implements ProductoCategoriaRepository{
    private Sql2o sql2o;

    @Override
    public Empresa_Administrador crear(Empresa_Administrador Empresa_admin) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO empresa_administrador(id_empresa,id_administrador)" +
                    "VALUES(:id_empresa,:id_administrador) ";
            conn.createQuery(sql,true)
                    .addParameter("id_empresa",Empresa_admin.getId_empresa())
                    .addParameter("id_administrador",Empresa_admin.getId_administrador())
                    .executeUpdate();
            return Empresa_admin;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Empresa_Administrador Empresa_admin, int id_empresa_Administrador) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update empresa_administrador set id_empresa =:id_empresa, id_administrador=:id_administrador";
            conn.createQuery(updateSql)
                    .addParameter("id_empresa",Empresa_admin.getId_empresa())
                    .addParameter("id_administrador",Empresa_admin.getId_administrador())
                    .executeUpdate();
            return "Se actualizo ID EMPRESA Y ID ADMINISTRADOR";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Falló la actualizacion de ID EMPRESA Y ID ADMINISTRADOR";
        }

    }

    @Override
    public List<Empresa_Administrador> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from empresa_administrador order by id_empresa_administrador asc ")
                    .executeAndFetch(Empresa_Administrador.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Empresa_Administrador> show(int id_empresa_Administrador) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from empresa_administrador where id_empresa_administrador=:id_empresa_Administrador ")
                    .addParameter("id_empresa_administrador ",id_empresa_Administrador)
                    .executeAndFetch(Empresa_Administrador.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_empresa_Administrador) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from empresa_administrador where id_empresa_administrador=:id_empresa_Administrador")
                    .addParameter("id_empresa_administrador",id_empresa_Administrador)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
