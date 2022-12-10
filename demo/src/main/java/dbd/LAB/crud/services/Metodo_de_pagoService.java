package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Metodo_de_pago;
import dbd.LAB.crud.repositories.Metodo_de_pagoImp;
import dbd.LAB.crud.repositories.Metodo_de_pagoRepository;

import java.util.List;

public class Metodo_de_pagoService {

    private final Metodo_de_pagoRepository metodoDePagoRepository;

    public Metodo_de_pagoService(Metodo_de_pagoRepository metodoDePagoRepository) {
        this.metodoDePagoRepository = metodoDePagoRepository;
    }

    public Metodo_de_pago crear(Metodo_de_pago metodoDePago){
        Metodo_de_pago resultado = metodoDePagoRepository.crear(metodoDePago);
        return resultado;
    }

    public List<Metodo_de_pago> getAllMetododepago(){
        return metodoDePagoRepository.getAll();
    }

    public List<Metodo_de_pago> getMetododepago(int id_tipopago){
        return metodoDePagoRepository.show(id_tipopago);
    }

    public String updateMetodopago(Metodo_de_pago metodoDePago,int id_tipopago){
        String retorno = metodoDePagoRepository.update(metodoDePago,id_tipopago);
        return retorno;
    }

    public void borrar(int id_tipopago){
        metodoDePagoRepository.delete(id_tipopago);
    }
}
