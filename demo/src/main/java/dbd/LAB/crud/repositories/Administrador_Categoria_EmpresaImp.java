package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Administrador_Categoria_Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;


@Repository
public class Administrador_Categoria_EmpresaImp implements Administrador_Categoria_EmpresaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public  Administrador_Categoria_Empresa crear(Administrador_Categoria_Empresa Administrador_Categoria_Empresa){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO administrador_categoria_empresa (id_admin,id_categoria)" +
                    "VALUES (:id_admin,:id_categoria)";
            conn.createQuery(sql, true)
                    //.addParameter("id_admin_categoria_empresa",Administrador_Categoria_Empresa.getId_admin_categoria_empresa())
                    .addParameter("id_admin", Administrador_Categoria_Empresa.getId_admin())
                    .addParameter("id_categoria", Administrador_Categoria_Empresa.getId_categoria())
                    .executeUpdate();
            return Administrador_Categoria_Empresa;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }



    @Override
    public List<Administrador_Categoria_Empresa> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from administrador_categoria_empresa order by nombre ASC")
                    .executeAndFetch(Administrador_Categoria_Empresa.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Administrador_Categoria_Empresa> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from administrador_categoria_empresa where id = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Administrador_Categoria_Empresa.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }




    @Override
    public void delete(int  id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from administrador_categoria_empresa where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public String update(Administrador_Categoria_Empresa Administrador_Categoria_Empresa, int  id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update administrador_categoria_empresa set id_admin=:id_admin WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_admin", Administrador_Categoria_Empresa.getId_admin())
                    .executeUpdate();
            return "Se actualizó el Administrador_Categoria_Empresa";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar Administrador_Categoria_Empresa";
        }
    }}





