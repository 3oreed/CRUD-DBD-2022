package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Boleta;
import dbd.LAB.crud.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class CategoriaImp {
    @Autowired
    private Sql2o sql2o;
    public Categoria crear(Categoria categoria) {

        try (Connection conn = sql2o.open()){
            String sql = "INSERT INTO pago(nombre,descripcion,id_tienda)"
                    + "VALUES (:nombre,:descripcion,:id_tienda)";
            conn.createQuery(sql,true)
                    .addParameter("nombre",categoria.getNombreCategoria())
                    .addParameter("descripcion",categoria.getDescripcion())
                    .addParameter("id_tienda",categoria.getId_tienda())
                    .executeUpdate();
            return categoria;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String update(Categoria categoria, int id_categoria) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update categoria set nombre=:nombre,descripcion=:descripcion,id_tienda=:id_tienda WHERE id_categoria=:id_categoria";
            conn.createQuery(updateSql)
                    .addParameter("nombre",categoria.getNombreCategoria())
                    .addParameter("descripcion",categoria.getDescripcion())
                    .addParameter("id_tienda",categoria.getId_tienda())
                    .executeUpdate();
            return "Se actualizó CATEGORIA";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar Categoria";
        }
    }

    public String updateDesc(Categoria categoria, int id_categoria) {
        try(Connection conn = sql2o.open()){
            String updateSql = "update boleta set descripcion=:descripcion WHERE id_categoria=:id_categoria6";
            conn.createQuery(updateSql)
                    .addParameter("descripcion",categoria.getDescripcion())
                    .executeUpdate();
            return "Se actualizó DESCRIPCION de tienda";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Fallo al actualizar DESCRIPCION de tienda";
        }

    }

    public List<Categoria> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * from categoria order by id_categoria asc")
                    .executeAndFetch(Categoria.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Categoria> show(int id_categoria) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from categoria where id_cateoria=:id_categoria ")
                    .addParameter("id_categoria",id_categoria)
                    .executeAndFetch(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void delete(int id_categoria) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from categoria where id_categoria = :id_categoria")
                    .addParameter("id_categoria",id_categoria)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
