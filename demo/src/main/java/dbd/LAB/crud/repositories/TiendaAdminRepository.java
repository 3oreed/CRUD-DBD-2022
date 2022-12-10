package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.TiendaAdmin;

import java.util.List;


public interface TiendaAdminRepository{

    public TiendaAdmin crear(TiendaAdmin TiendaAdmin );
    public String update(TiendaAdmin TiendaAdmin  , int idTiendaAdmin);
    public List<TiendaAdmin> getAll();
    public List<TiendaAdmin> show(int idTiendaAdmin );
    public void delete(int idTiendaAdmin );
}
