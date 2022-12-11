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
    public TiendaAdmin crear(TiendaAdmin tiendaAdmin) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO tienda_admin(id_admin,id_admin)" +
                    "VALUES (:id_admin,:id_tienda)";
            conn.createQuery(sql,true)
                    .addParameter("id_admin",tiendaAdmin.getId_admin())
                    .addParameter("id_tienda",tiendaAdmin.getId_tienda())
                    .executeUpdate();
            return tiendaAdmin;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(TiendaAdmin tiendaAdmin, int id_tienda_admin) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update tienda_admin set id_admin=:id_admin WHERE id_tienda_admin=:id_tienda_admin";
            conn.createQuery(updateSql)
                    .addParameter("id_admin",tiendaAdmin.getId_admin())
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
            return conn.createQuery("SELECT * from tienda_admin order by id_tienda_admin asc")
                    .executeAndFetch(TiendaAdmin.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<TiendaAdmin> show(int id_tienda_admin) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tienda_admin where id_tienda_admin = :id_tienda_admin")
                    .addParameter("id_tienda_admin",id_tienda_admin)
                    .executeAndFetch(TiendaAdmin.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_tienda_admin) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from tienda_admin where id_tienda_admin= :id_tienda_admin")
                    .addParameter("id_tienda_admin",id_tienda_admin)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
