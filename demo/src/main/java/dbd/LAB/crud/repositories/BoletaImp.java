

package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Boleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class BoletaImp implements BoletaRepository{
    private Sql2o sql2o;

    @Override
    public Boleta crear(Boleta Boleta) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO pago(id_Boleta,id_pago,detalle_compra)" +
                    "VALUES (:id_Boleta,:id_pago,:id_empresa)";
            conn.createQuery(sql,true)
                    .addParameter("id_Boleta",Boleta.getId_Boleta())
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
    public String update(Boleta Boleta, int id_Boleta) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update Boleta set detalle_compra=:detalle_compra WHERE id_Boleta=:id_Boleta";
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
            return conn.createQuery("SELECT * from Boleta order by id_Boleta asc")
                    .executeAndFetch(Boleta.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Boleta> show(int id_Boleta) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Boleta where id_Boleta = :id_Boleta ")
                    .addParameter("id_Boleta",id_Boleta)
                    .executeAndFetch(Boleta.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_Boleta) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Boleta where id_Boleta = :id_Boleta")
                    .addParameter("id_Boleta",id_Boleta)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}


