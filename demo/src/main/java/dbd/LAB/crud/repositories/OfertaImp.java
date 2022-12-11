package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Oferta;
import dbd.LAB.crud.models.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.net.ConnectException;
import java.time.LocalDate;
import java.util.List;
@Repository
public class OfertaImp implements OfertaRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public Oferta crear(Oferta oferta) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO oferta(descripcion,stock_oferta,fecha_inicio,fecha_final,id_prod)" +
                    "VALUES (:descripcion,:stock_oferta,:fecha_inicio,:fecha_final,:id_prod)";
            conn.createQuery(sql,true)
                    .addParameter("descripcion",oferta.getDescripcion())
                    .addParameter("stock_oferta",oferta.getStock_oferta())
                    .addParameter("fecha_inicio", LocalDate.parse(oferta.getFecha_inicio()))
                    .addParameter("fecha_final",LocalDate.parse(oferta.getFecha_final()))
                    .addParameter("id_prod",oferta.getId_prod())
                    .executeUpdate();
            return oferta;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;

    }

    @Override
    public String update(Oferta oferta, int id_oferta) {
        try (Connection conn = sql2o.open()){
            String updateSql = "update oferta set descripcion=:descripcion,stock_oferta=:stock_oferta,fecha_inicio=:fecha_inicio,fecha_final=:fecha_final where id_oferta=:id_oferta";
            conn.createQuery(updateSql,true)
                    .addParameter("descripcion",oferta.getDescripcion())
                    .addParameter("stock_oferta",oferta.getStock_oferta())
                    .addParameter("fecha_inicio", LocalDate.parse(oferta.getFecha_inicio()))
                    .addParameter("fecha_final",LocalDate.parse(oferta.getFecha_final()))
                    .addParameter("id_oferta",id_oferta)
                    .executeUpdate();
            return "Se actualizó informacion de OFERTA";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar OFERTA";
        }


    }

    public String updateStock(Oferta oferta, int id) {
        try (Connection conn = sql2o.open()){
            String updateSql = "update oferta set stock_oferta=:stock_oferta where id_oferta=:id_oferta";
            conn.createQuery(updateSql,true)
                    .addParameter("stock_oferta",oferta.getStock_oferta())
                    .addParameter("id_oferta",id)
                    .executeUpdate();
            return "Se actualizó informacion de OFERTA";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar OFERTA";
        }

    }

    @Override
    public List<Oferta> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from oferta order by  id_oferta")
                    .executeAndFetch(Oferta.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Oferta> show(int id_oferta) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from oferta where id_oferta = :id_oferta ")
                    .addParameter("id_oferta",id_oferta)
                    .executeAndFetch(Oferta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

    @Override
    public void delete(int id_oferta) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM oferta where id_oferta=:id_oferta")
                    .addParameter("id_oferta",id_oferta)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
