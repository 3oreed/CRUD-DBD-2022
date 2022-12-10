package dbd.LAB.crud.repositories;


import dbd.LAB.crud.models.Cliente_ProductoCategoria;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Cliente_ProductoCategoriaImp implements Cliente_ProductoCategoriaRepository{
    private Sql2o sql2o;

    @Override
    public Cliente_ProductoCategoria crear(Cliente_ProductoCategoria clienteProdCat) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO cliente_productocategoria(id_cliente,cliente_productocategoria)" +
                    "values (:id_cliente,:cliente_productocategoria)";
            conn.createQuery(sql,true)

                    .addParameter("id_cliente",clienteProdCat.getId_cliente())
                    .addParameter("cliente_productocategoria",clienteProdCat.getProdCat())

                    .executeUpdate();
            return clienteProdCat;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(Cliente_ProductoCategoria clienteProdCat, int id_cliente_productocategoria) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update cliente_productocategoria set cliente_productocategoria=:id_cliente_productocategoria" +
                    " WHERE cliente_productocategoria=:id_cliente_productocategoria";
            conn.createQuery(updateSql)
                    .addParameter("cliente_productocategoria",clienteProdCat.getId_cliente_productoCategoria())
                    .executeUpdate();
            return "Se actualizo id de un Cliente_ProductoCategoria";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar id de Cliente_ProductoCategoria";
        }

    }

    @Override
    public List<Cliente_ProductoCategoria> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from cliente_productocategoria order by cliente_productocategoria asc ")
                    .executeAndFetch(Cliente_ProductoCategoria.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Cliente_ProductoCategoria> show(int cliente_productocategoria) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from Cliente_ProductoCategoria where cliente_productocategoria=:cliente_productocategoria ")
                    .addParameter("cliente_productocategoria ",cliente_productocategoria)
                    .executeAndFetch(Cliente_ProductoCategoria.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int cliente_productocategoria) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Cliente_ProductoCategoria where cliente_productocategoria=:cliente_productocategoria")
                    .addParameter("cliente_productocategoria",cliente_productocategoria)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
