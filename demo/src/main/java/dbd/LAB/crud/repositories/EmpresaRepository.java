package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Empresa;

import java.util.List;

public interface EmpresaRepository {
    public Empresa crear(Empresa empresa);

    public String updatePass(Empresa empresa, int id_empresa);
    public String updateMail(Empresa empresa, int id_empresa);

    public List<Empresa> getAll();

    public List<Empresa> show(int id_empresa);

    public void delete(int id_empresa);
}
