package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Metodo_de_pago;

import dbd.LAB.crud.models.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class Metodo_de_pagoImp implements Metodo_de_pagoRepository {
    @Autowired
    private Sql2o sql2o;
    @Override
    public Metodo_de_pago crear(Metodo_de_pago tipo_de_pago) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO metodo_de_pago(nombre_metodo)" +
                    "VALUES(:nombre_metodo)";
            conn.createQuery(sql,true)
                    .addParameter("metodo_pago",tipo_de_pago.getNombre_metodo())
                    .executeUpdate();
                    return tipo_de_pago;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Metodo_de_pago tipo_de_pago, int id_tipo_de_pago) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update metodo_de_pago set nombre_metodo=:nombre_metodo WHERE id_tipopago=:id_tipo_de_pago";
            conn.createQuery(updateSql)
                    .addParameter("nombre_metodo",tipo_de_pago.getNombre_metodo())
                    .addParameter("id_tipo_de_pago",id_tipo_de_pago)
                    .executeUpdate();
            return "Se actualizó el NOMBRE DEL METODO DE PAGO";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar NOMBRE DEL METODO DE PAGO";
        }

    }

    @Override
    public List<Metodo_de_pago> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from metodo_de_pago order by id_tipopago asc ")
                    .executeAndFetch(Metodo_de_pago.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<Metodo_de_pago> show(int id_tipo_de_pago) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from metodo_de_pago where id_tipopago = :id_tipo_de_pago ")
                    .addParameter("id_tipo_de_pago",id_tipo_de_pago)
                    .executeAndFetch(Metodo_de_pago.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_tipo_de_pago) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from metodo_de_pago where id_tipopago = :id_tipo_de_pago")
                    .addParameter("id_tipo_de_pago",id_tipo_de_pago)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
