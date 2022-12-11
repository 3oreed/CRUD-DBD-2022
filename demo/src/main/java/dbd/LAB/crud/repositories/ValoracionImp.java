package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Valoracion;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;

@Repository
public class ValoracionImp implements ValoracionRepository{
    @Autowired
    private Sql2o sql2o;


    public Valoracion crear(Valoracion valoracion) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO valoracion(puntuacion,opinion,favoritos,id_cliente,id_empresa)" +
                    "VALUES (:puntuacion,:opinion,:favoritos,:id_cliente,:id_empresa)";
            conn.createQuery(sql,true)

                    .addParameter("puntuacion",valoracion.getPuntuacion())
                    .addParameter("opinion",valoracion.getOpinion())
                    .addParameter("favoritos",valoracion.getFavoritos())
                    .addParameter("id_cliente",valoracion.getId_cliente())
                    .addParameter("id_empresa",valoracion.getId_empresa())
                    .executeUpdate();
            return valoracion;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    public String update(Valoracion Valoracion, int id_valoracion) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update valoracion set favoritos=:favoritos WHERE id_valoracion=:id_valoracion";
            conn.createQuery(updateSql)
                    .addParameter("favoritos",Valoracion.getFavoritos())
                    .addParameter("id_valoracion",id_valoracion)
                    .executeUpdate();
            return "Se actualizó el Valoracion";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar Valoracion";
        }

    }


    public List<Valoracion> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from valoracion order by id_valoracion asc")
                    .executeAndFetch(Valoracion.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }


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


