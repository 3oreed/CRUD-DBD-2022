package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Valoracion;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;
        import org.sql2o.Connection;
        import org.sql2o.Sql2o;
        import java.util.List;

public class ValoracionImp implements ValoracionRepository{
    private Sql2o sql2o;

    @Override
    public Valoracion crear(Valoracion Valoracion) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO Valoracion(idValoracion,puntuacion,opinion,favoritos,idCliente,idEmpresa)" +
                    "VALUES (:idValoracion,:puntuacion,:opinion,:favoritos,:idCliente,:idEmpresa)";
            conn.createQuery(sql,true)
                    .addParameter("idValoracion",Valoracion.getIdValoracion())
                    .addParameter("puntuacion",Valoracion.getPuntuacion())
                    .addParameter("opinion",Valoracion.getOpinion())
                    .addParameter("favoritos",Valoracion.getFavoritos())
                    .addParameter("idCliente",Valoracion.getIdCliente())
                    .addParameter("idEmpresa",Valoracion.getIdEmpresa())





                    .executeUpdate();
            return Valoracion;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Valoracion Valoracion, int idValoracion) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update Valoracion set puntuacion=:puntuacion WHERE idValoracion=:idValoracion";
            conn.createQuery(updateSql)
                    .addParameter("puntuacion",Valoracion.getPuntuacion())
                    .executeUpdate();
            return "Se actualizó el Valoracion";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar Valoracion";
        }

    }

    @Override
    public List<Valoracion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from Valoracion order by idValoracion asc")
                    .executeAndFetch(Valoracion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Valoracion> show(int idValoracion) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Valoracion where idValoracion = :idValoracion")
                    .addParameter("idValoracion",idValoracion)
                    .executeAndFetch(Valoracion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int idValoracion) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Valoracion where idValoracion= :idValoracion")
                    .addParameter("idValoracion",idValoracion)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}


