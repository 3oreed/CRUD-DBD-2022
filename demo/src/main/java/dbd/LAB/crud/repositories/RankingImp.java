package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class RankingImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Ranking crear(Ranking ranking) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO  ranking(nombre_empresa,lugar)" +
                    "VALUES(:nombre_empresa,:lugar)";
            conn.createQuery(sql, true)
                    .addParameter("nombre_empresa", ranking.getNombre_empresa())
                    .addParameter("lugar", ranking.getLugar())
                    .executeUpdate();
            return ranking;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Ranking ranking, int id_ranking) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "update ranking set lugar=:lugar where id_ranking=:id_ranking";
            conn.createQuery(updateSql)
                    .addParameter("lugar", ranking.getLugar())
                    .addParameter("id_ranking",id_ranking)
                    .executeUpdate();
            return "Se actualizó el lugar del ranking";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar detalle_compra";
        }
    }
    @Override
    public List<Ranking> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * from ranking order by lugar asc")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
    public List<Ranking> show(int lugar) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ranking where lugar = :lugar")
                    .addParameter("lugar",lugar)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
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