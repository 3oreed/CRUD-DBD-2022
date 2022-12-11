package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Boleta;
import dbd.LAB.crud.models.Empresa;
import dbd.LAB.crud.models.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class TiendaImp {
    @Autowired
    private Sql2o sql2o;
    public Tienda crear(Tienda tienda) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO tienda(nombre,edad_minima,codigo_postal,tipo_empresa,id_empresa)"
                    + "VALUES (:nombre,:edad_minima,:codigo_postal,:tipo_empresa,:id_empresa)";
            conn.createQuery(sql,true)

                    .addParameter("nombre",tienda.getNombreTienda())
                    .addParameter("edad_minima",tienda.getEdadMinima())
                    .addParameter("codigo_postal",tienda.getPostalCode())
                    .addParameter("tipo_empresa",tienda.getTipoEmpresa())
                    .executeUpdate();
            return tienda;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String updateNombre(Tienda tienda, int id_tienda) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update tienda set nombre=:nombre WHERE id_tienda=:id_tienda";
            conn.createQuery(updateSql)
                    .addParameter("nombre",tienda.getNombreTienda())
                    .executeUpdate();
            return "Se actualizó el nombre de tienda";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar nombre de tienda";
        }
    }

    public String update(Tienda tienda, int id_tienda) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update boleta set nombre=:nombre,edad_minima=:edad_minima,codig_postal=:codigo_postal,tipo_empresa=:tipo_empresa WHERE id_tienda=:id_tienda";
            conn.createQuery(updateSql)
                    .addParameter("nombre",tienda.getNombreTienda())
                    .addParameter("edad_minima",tienda.getEdadMinima())
                    .addParameter("codigo_postal",tienda.getPostalCode())
                    .addParameter("tipo_empresa",tienda.getTipoEmpresa())
                    .executeUpdate();
            return "Se actualizó tienda";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar tienda.";
        }
    }

    public List<Tienda> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from tienda order by id_tienda asc")
                    .executeAndFetch(Tienda.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Tienda> show(int id_tienda) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tienda where id_tienda = :id_tienda ")
                    .addParameter("id_tienda",id_tienda)
                    .executeAndFetch(Tienda.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void delete(int id_tienda) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from tienda where id_tienda = :id_tienda")
                    .addParameter("id_tienda",id_tienda)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
