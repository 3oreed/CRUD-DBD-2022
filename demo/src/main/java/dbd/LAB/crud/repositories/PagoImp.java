package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class PagoImp implements PagoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Pago crear(Pago pago) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO pago(monto,id_tipopago,id_empresa)" +
                    "VALUES (:monto,:id_tipopago,:id_empresa)";
            conn.createQuery(sql,true)
                    .addParameter("monto",pago.getMonto())
                    .addParameter("id_tipopago",pago.getId_tipo_pago())
                    .addParameter("id_empresa",pago.getId_empresa())
                    .executeUpdate();
                    return pago;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Pago pago, int id_pago) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update pago set monto=:monto WHERE id_pago=:id_pago";
            conn.createQuery(updateSql)
                    .addParameter("monto",pago.getMonto())
                    .executeUpdate();
            return "Se actualizó el MONTO de pago";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar MONTO de pago";
        }

    }

    @Override
    public List<Pago> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from pago order by id_pago asc")
                    .executeAndFetch(Pago.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Pago> show(int id_pago) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from pago where id_pago = :id_pago ")
                    .addParameter("id_pago",id_pago)
                    .executeAndFetch(Pago.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void delete(int id_pago) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from pago where id_pago = :id_pago")
                    .addParameter("id_pago",id_pago)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
