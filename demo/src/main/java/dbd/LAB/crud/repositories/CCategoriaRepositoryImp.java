package dbd.LAB.crud.repositories;


import dbd.LAB.crud.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class CCategoriaRepositoryImp implements CCategoriaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public Categoria crear(Categoria Categoria){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO Categoria (id,nombre)" +
            "VALUES (id, :nombre)";
            conn.createQuery(sql, true)
                .addColumnMapping("id", Categoria.getId_categoria())
                .addParameter("nombre", Categoria.getNombreCategoria())
                .executeUpdate();
                return Categoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


    
    @Override
    public List<Categoria> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Categoria order by nombre ASC")
                    .executeAndFetch(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Categoria> show(String id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Categoria where id = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Categoria.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }




    @Override
    public void delete(String id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Categoria where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }


    @Override
    public String update(Categoria Categoria, String id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Categoria set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                .addParameter("id", id)
                .addParameter("nombre", Categoria.getNombre_Categoria())
                .executeUpdate();
            return "Se actualizó el Categoria";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Categoria";
        }
    }

}