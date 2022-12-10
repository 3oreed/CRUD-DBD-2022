package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Valoracion;

import java.util.List;

public interface ValoracionRepository {

    public Valoracion crear(Valoracion Valoracion );
    public String update(Valoracion cliente , int idValoracion);
    public List<Valoracion> getAll();
    public List<Valoracion> show(int idValoracion);
    public void delete(int idValoracion);
}
