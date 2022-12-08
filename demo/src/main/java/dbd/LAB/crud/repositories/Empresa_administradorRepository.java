package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Empresa_Administrador;

import java.util.List;

public interface Empresa_administradorRepository {

    public Empresa_Administrador crear(Empresa_Administrador Empresa_admin);

    public String update(Empresa_Administrador Empresa_admin, int id_empresa_Administrador);

    public List<Empresa_Administrador> getAll();

    public List<Empresa_Administrador> show(int id_empresa_Administrador);

    public void delete(int id_empresa_Administrador);
}
