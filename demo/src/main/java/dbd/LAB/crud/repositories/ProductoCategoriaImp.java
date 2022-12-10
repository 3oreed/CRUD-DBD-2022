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
    public String update(Empresa_Administrador Empresa_admin, int id_empresa_Administrador) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update empresa_administrador set id_empresa =:id_empresa, id_administrador=:id_administrador";
            conn.createQuery(updateSql)
                    .addParameter("id_empresa",Empresa_admin.getId_empresa())
                    .addParameter("id_administrador",Empresa_admin.getId_administrador())
                    .executeUpdate();
            return "Se actualizo ID EMPRESA Y ID ADMINISTRADOR";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Falló la actualizacion de ID EMPRESA Y ID ADMINISTRADOR";
        }

    }

    @Override
    public List<Empresa_Administrador> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from empresa_administrador order by id_empresa_administrador asc ")
                    .executeAndFetch(Empresa_Administrador.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Empresa_Administrador> show(int id_empresa_Administrador) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from empresa_administrador where id_empresa_administrador=:id_empresa_Administrador ")
                    .addParameter("id_empresa_administrador ",id_empresa_Administrador)
                    .executeAndFetch(Empresa_Administrador.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id_empresa_Administrador) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from empresa_administrador where id_empresa_administrador=:id_empresa_Administrador")
                    .addParameter("id_empresa_administrador",id_empresa_Administrador)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
