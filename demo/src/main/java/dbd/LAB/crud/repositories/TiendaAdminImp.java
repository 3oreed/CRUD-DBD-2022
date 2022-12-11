package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.TiendaAdmin;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TiendaAdminImp implements TiendaAdminRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public TiendaAdmin crear(TiendaAdmin TiendaAdmin) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO TiendaAdmin(idTiendaAdmin,idAdmin,idTienda)" +
                    "VALUES (:idTiendaAdmin,:idAdmin,:idTienda)";
            conn.createQuery(sql,true)
                    .addParameter("idTiendaAdmin",TiendaAdmin.getIdTiendaAdmin())
                    .addParameter("idAdmin",TiendaAdmin.getIdAdmin())
                    .addParameter("idTienda",TiendaAdmin.getIdTienda())


                    .executeUpdate();
            return TiendaAdmin;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(TiendaAdmin TiendaAdmin, int idTiendaAdmin) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update TiendaAdmin set idAdmin=:idAdmin WHERE idTiendaAdmin=:idTiendaAdmin";
            conn.createQuery(updateSql)
                    .addParameter("idAdmin",TiendaAdmin.getIdAdmin())
                    .executeUpdate();
            return "Se actualizó el TiendaAdmin";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar TiendaAdmin";
        }

    }

    @Override
    public List<TiendaAdmin> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from TiendaAdmin order by idTiendaAdmin asc")
                    .executeAndFetch(TiendaAdmin.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<TiendaAdmin> show(int idTiendaAdmin) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from TiendaAdmin where idTiendaAdmin = :idTiendaAdmin")
                    .addParameter("idTiendaAdmin",idTiendaAdmin)
                    .executeAndFetch(TiendaAdmin.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int idTiendaAdmin) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from TiendaAdmin where idTiendaAdmin= :idTiendaAdmin")
                    .addParameter("idTiendaAdmin",idTiendaAdmin)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
