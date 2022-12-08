package dbd.LAB.crud.repositories;


import dbd.LAB.crud.models.Oferta;


import java.util.List;

public interface OfertaRepository {

    public Oferta crear(Oferta oferta);

    public String update(Oferta oferta, int id_oferta);

    public List<Oferta> getAll();

    public List<Oferta> show(int id_oferta);

    public void delete(int id_oferta);
}
