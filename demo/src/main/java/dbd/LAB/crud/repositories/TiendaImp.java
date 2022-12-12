package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class TiendaImp implements TiendaRepository{
    @Autowired
    private Sql2o sql2o;
    @Override
    public Tienda crear(Tienda tienda) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO tienda(nombre,edad_minima,ciudad,tipo_empresa,id_empresa)"
                    + "VALUES (:nombre,:edad_minima,:ciudad,:tipo_empresa,:id_empresa)";
            conn.createQuery(sql,true)

                    .addParameter("nombre",tienda.getNombre())
                    .addParameter("edad_minima",tienda.getEdad_minima())
                    .addParameter("ciudad",tienda.getCiudad())
                    .addParameter("tipo_empresa",tienda.getTipo_empresa())
                    .addParameter("id_empresa",tienda.getId_empresa())

                    .executeUpdate();
            return tienda;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Override
    public String updateNombre(Tienda tienda, int id_tienda) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update tienda set nombre=:nombre WHERE id_tienda=:id_tienda";
            conn.createQuery(updateSql)
                    .addParameter("id_tienda",id_tienda)
                    .addParameter("nombre",tienda.getNombre())
                    .executeUpdate();
            return "Se actualizó el nombre de tienda";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar nombre de tienda";
        }
    }
    @Override
    public List<Tienda> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from tienda order by id_tienda asc")
                    .executeAndFetch(Tienda.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
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
    @Override
    public List<Tienda> showByEdadMin(int edad_minima) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tienda where edad_minima<=:edad_minima ")
                    .addParameter("edad_minima",edad_minima)
                    .executeAndFetch(Tienda.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tienda> showByTipoEmpresa(String tipo_empresa) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tienda where tipo_empresa=:tipo_empresa")
                    .addParameter("tipo_empresa",tipo_empresa)
                    .executeAndFetch(Tienda.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tienda> showByCiudad(String ciudad) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tienda where ciudad=:ciudad")
                    .addParameter("ciudad",ciudad)
                    .executeAndFetch(Tienda.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
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
