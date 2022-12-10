package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Pago;
import dbd.LAB.crud.repositories.PagoRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public Pago crear(Pago pago){
        Pago resultado = pagoRepository.crear(pago);
        return resultado;
    }
    @GetMapping("/Pago")
    public List<Pago> getAllpago(){
        return pagoRepository.getAll();
    }

    public List<Pago> getPago(int id_pago) {
        return pagoRepository.show(id_pago);
    }

    public String updatePago(Pago pago, int id_pago){
        String retorno = pagoRepository.update(pago,id_pago);
        return retorno;
    }

    public void borrar(int id_pago){

        pagoRepository.delete(id_pago);
    }

}
