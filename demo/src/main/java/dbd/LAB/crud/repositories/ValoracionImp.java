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
@Repository
public class ValoracionImp implements ValoracionRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Valoracion crear(Valoracion Valoracion) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO valoracion(id_valoracion,puntuacion,opinion,favoritos,id_cliente,id_empresa)" +
                    "VALUES (:id_valoracion,:puntuacion,:opinion,:favoritos,:id_cliente,:id_empresa)";
            conn.createQuery(sql,true)
                    .addParameter("id_valoracion",Valoracion.getIdValoracion())
                    .addParameter("puntuacion",Valoracion.getPuntuacion())
                    .addParameter("opinion",Valoracion.getOpinion())
                    .addParameter("favoritos",Valoracion.getFavoritos())
                    .addParameter("id_cliente",Valoracion.getIdCliente())
                    .addParameter("id_empresa",Valoracion.getIdEmpresa())

                    .executeUpdate();
            return Valoracion;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Valoracion Valoracion, int id_valoracion) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update valoracion set puntuacion=:puntuacion WHERE id_valoracion=:id_valoracion";
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
            return conn.createQuery("select * from valoracion order by id_valoracion asc")
                    .executeAndFetch(Valoracion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Valoracion> show(int id_valoracion) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from valoracion where id_valoracion = :id_valoracion")
                    .addParameter("id_valoracion",id_valoracion)
                    .executeAndFetch(Valoracion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_valoracion) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("delete from valoracion where id_valoracion= :id_valoracion")
                    .addParameter("id_valoracion",id_valoracion)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}


