package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.ProductoCategoria;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class ProductoCategoriaImp implements ProductoCategoriaRepository{
    private Sql2o sql2o;

    @Override
    public ProductoCategoria crear(ProductoCategoria prodCat) {
        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO productocategoria (nombre,descripcion,precio,stock_inicial," +
                    "stock_actual,vendidos,id_carrito,id_empresa,id_categoria) " +
                    "VALUES(:nombre,:descripcion,:precio,:stock_inicial," +
                    ":stock_actual,:vendidos,:id_carrito,:id_empresa,:id_categoria)";
            conn.createQuery(sql,true)

                    .addParameter("nombre",prodCat.getNombrProdCat())
                    .addParameter("descripcion",prodCat.getDesc())
                    .addParameter("precio",prodCat.getPrecio())
                    .addParameter("stock_inicial",prodCat.getInitialStock())
                    .addParameter("stock_actual",prodCat.getCurrentStock())
                    .addParameter("vendidos",prodCat.getVendidos())
                    .addParameter("id_carrito",prodCat.getId_carrito())
                    .addParameter("id_empresa",prodCat.getId_empresa())
                    .addParameter("id_categoria",prodCat.getId_categoria())

                    .executeUpdate();
            return prodCat;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String update(ProductoCategoria prodCat, int id_prod) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update productocategoria set precio=:precio where id_prod=:id_prod";
            conn.createQuery(updateSql)
                    .addParameter("precio",prodCat.getPrecio())
                    .executeUpdate();
            return "Se actualizo precio de un productocategoria";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar precio de productocategoria";
        }

    }

    @Override
    public List<ProductoCategoria> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from productocategoria order by id_prod asc ")
                    .executeAndFetch(ProductoCategoria.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductoCategoria> show(int id_prod) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from productocategoria where id_prod=:id_prod ")
                    .addParameter("id_prod ",id_prod)
                    .executeAndFetch(ProductoCategoria.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_prod) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from productocategoria where id_prod=:id_prod")
                    .addParameter("id_prod",id_prod)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
