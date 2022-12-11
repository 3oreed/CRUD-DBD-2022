package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Cliente_tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class Cliente_tiendaImp implements Cliente_tiendaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Cliente_tienda crear(Cliente_tienda clienteTienda) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO cliente_tienda (id_cliente,id_tienda,edad_minima)" +
                    "VALUES (:id_cliente,:id_tienda,:edad_minima)";
            conn.createQuery(sql,true)

                    .addParameter("id_cliente",clienteTienda.getId_cliente())
                    .addParameter("id_tienda",clienteTienda.getId_tienda())
                    .addParameter("edad_minima",clienteTienda.getEdad_minima())

                    .executeUpdate();
            return clienteTienda;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Cliente_tienda clienteTienda, int id_cliente_tienda) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update cliente_tienda set edad_minima=:edad_minima where id_cliente_tienda=:id_cliente_tienda";
            conn.createQuery(updateSql)
                    .addParameter("edad_minima",clienteTienda.getEdad_minima())
                    .addParameter("id_cliente_tienda",id_cliente_tienda)
                    .executeUpdate();
            return "Se actualizo edad minima de Cliente_tienda";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar id_cliente_tienda de Cliente_tienda";
        }

    }

    @Override
    public List<Cliente_tienda> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from cliente_tienda order by id_cliente_tienda asc ")
                    .executeAndFetch(Cliente_tienda.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Cliente_tienda> show(int id_cliente_tienda) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from cliente_tienda where id_cliente_tienda=:id_cliente_tienda ")
                    .addParameter("id_cliente_tienda",id_cliente_tienda)
                    .executeAndFetch(Cliente_tienda.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_cliente_tienda) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from cliente_tienda where id_cliente_tienda=:id_cliente_tienda")
                    .addParameter("id_cliente_tienda",id_cliente_tienda)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
