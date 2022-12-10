package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Oferta;
import dbd.LAB.crud.repositories.OfertaRepository;

import java.util.List;

public class OfertaService {

    private final OfertaRepository ofertaRepository;

    public OfertaService(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }

    public Oferta crear(Oferta oferta){
        Oferta resultado = ofertaRepository.crear(oferta);
        return resultado;
    }

    public List<Oferta> getAllOferta(){
        return ofertaRepository.getAll();
    }

    public  List<Oferta> getOferta(int id_oferta){
        return ofertaRepository.show(id_oferta);
    }

    public String updateOferta(Oferta oferta, int id_oferta){
        String retorno = ofertaRepository.update(oferta,id_oferta);
        return retorno;
    }

    public void borrar(int id_oferta){
        ofertaRepository.delete(id_oferta);
    }
}
