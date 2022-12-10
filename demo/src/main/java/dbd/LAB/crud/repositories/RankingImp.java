package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Boleta;
import dbd.LAB.crud.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.net.ConnectException;
import java.util.List;

public class RankingImp {

    private Sql2o sql2o;

    public Ranking crear(Ranking ranking) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO ranking(nombre_empresa,lugar)" +
                    "VALUES(:nombre_empresa,:lugar)";
            conn.createQuery(sql, true)
                    .addParameter("nombre_empresa", ranking.getNombreEmpresa())
                    .addParameter("lugar", ranking.getLugarRanking())
                    .executeUpdate();
            return ranking;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public String update(Ranking ranking, int id_ranking) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update ranking set lugar=:lugar where id_ranking=:id_ranking";
            conn.createQuery(updateSql)
                    .addParameter("lugar", ranking.getLugarRanking())
                    .executeUpdate();
            return "Se actualizó el lugar del ranking";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar detalle_compra";
        }
    }

    public List<Ranking> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * from ranking order by lugar asc")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Ranking> showLugar3(int lugar) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ranking where lugar = :lugar")
                    .addParameter("lugar",lugar)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void delete(int id_ranking) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from ranking where id_ranking = :id_ranking")
                    .addParameter("id_ranking",id_ranking)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}