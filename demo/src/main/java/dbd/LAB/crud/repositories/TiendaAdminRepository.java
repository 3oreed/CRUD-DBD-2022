package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.TiendaAdmin;

import java.util.List;


public interface TiendaAdminRepository{

    public TiendaAdmin crear(TiendaAdmin tiendaAdmin );
    public String update(TiendaAdmin tiendaAdmin  , int id_tienda_admin);
    public List<TiendaAdmin> getAll();
    public List<TiendaAdmin> show(int id_tienda_admin );
    public void delete(int id_tienda_admin );
}
