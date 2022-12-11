

package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Boleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class BoletaImp implements BoletaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Boleta crear(Boleta Boleta) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO pago(id_boleta,id_pago,detalle_compra)"
                    + "VALUES (:id_pago,:id_empresa)";
            conn.createQuery(sql,true)
                    //.addParameter("id_boleta",Boleta.getId_Boleta())
                    .addParameter("id_tipopago",Boleta.getId_pago())
                    .addParameter("id_empresa",Boleta.getDetalle_compra())
                    .executeUpdate();
            return Boleta;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Boleta Boleta, int id_boleta) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update boleta set detalle_compra=:detalle_compra WHERE id_boleta=:id_boleta";
            conn.createQuery(updateSql)
                    .addParameter("detalle_compra",Boleta.getDetalle_compra())
                    .executeUpdate();
            return "Se actualizó el detalle_compra";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar detalle_compra";
        }

    }

    @Override
    public List<Boleta> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from boleta order by id_boleta asc")
                    .executeAndFetch(Boleta.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Boleta> show(int id_boleta) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from boleta where id_boleta = :id_boleta ")
                    .addParameter("id_boleta",id_boleta)
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_boleta) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from boleta where id_boleta = :id_boleta")
                    .addParameter("id_boleta",id_boleta)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}


