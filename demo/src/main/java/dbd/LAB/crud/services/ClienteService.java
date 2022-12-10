package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Cliente;
import dbd.LAB.crud.repositories.ClienteRepository;

import java.util.List;


public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crear(Cliente cliente){
        Cliente resultado = clienteRepository.crear(cliente);
        return resultado;
    }

    public List<Cliente> getAllCliente(){
        return clienteRepository.getAll();
    }

    public List<Cliente> getCliente(int id_cliente){
        return clienteRepository.show(id_cliente);
    }

    public String updateCliente(Cliente cliente,int id_cliente){
        String retorno = clienteRepository.update(cliente,id_cliente);
        return retorno;
    }

    public void borrar(int id_cliente){
        clienteRepository.delete(id_cliente);
    }


}
