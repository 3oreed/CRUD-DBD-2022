package dbd.LAB.crud.repositories;
import dbd.LAB.crud.models.Administrador_Categoria_Empresa;
import java.util.List;

public interface Administrador_Categoria_EmpresaRepository {
    public Administrador_Categoria_Empresa crear(Administrador_Categoria_Empresa Administrador_Categoria_Empresa);
    public String update(Administrador_Categoria_Empresa Administrador_Categoria_Empresa ,String id);
    public List<Administrador_Categoria_Empresa> getAll();
    public List<Administrador_Categoria_Empresa> show(String id);
    public void delete(String id);
}
