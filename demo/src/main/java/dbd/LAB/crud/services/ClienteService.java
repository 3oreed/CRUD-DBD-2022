package dbd.LAB.crud.services;
import dbd.LAB.crud.models.Cliente;
import dbd.LAB.crud.repositories.ClienteRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class ClienteService{
    private final ClienteRepository ClienteRepository;

    ClienteService(@Lazy ClienteRepository ClienteRepository){
        this.ClienteRepository = ClienteRepository;
    }

    // crear C
    @PostMapping("/Cliente")
    @ResponseBody
    public Cliente crear(@RequestBody Cliente Cliente){
        Cliente resultado = ClienteRepository.crear(Cliente);
        return resultado;
    }



    // get R
    @GetMapping("/Cliente")
    public List<Cliente> getAllClientes(){
        return ClienteRepository.getAll();
    }
    //get by
    @GetMapping("/Cliente/{id_cliente}")
    public List<Cliente> getClientes(@PathVariable int id_cliente){
        return ClienteRepository.show(id_cliente);
    }



    // actualizar U
    @PutMapping("/ClienteUpdatePass/{id_cliente}") //{id}(?)
    @ResponseBody
    public String updatePass(@RequestBody Cliente Cliente, @PathVariable int id_cliente){
        String retorno = ClienteRepository.update(Cliente,id_cliente);
        return retorno;
    }

    @PutMapping("/ClienteUpdateEmail/{id_cliente}")
    @ResponseBody
    public String updateEmail(@RequestBody Cliente cliente, @PathVariable int id_cliente){
        String retorno = ClienteRepository.updateMail(cliente,id_cliente);
        return retorno;
    }

    @PutMapping("/ClienteUpdateAll/{id_cliente}")
    @ResponseBody
    public String updateAll(@RequestBody Cliente cliente,@PathVariable int id_cliente){
        String retorno = ClienteRepository.updateAll(cliente,id_cliente);
        return retorno;
    }
    @PutMapping("/ClienteUpdateDireccion/{id_cliente}")
    @ResponseBody
    public String updateDireccion(@RequestBody Cliente cliente,@PathVariable int id_cliente){
        String retorno = ClienteRepository.updateDireccion(cliente, id_cliente);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Cliente/{id_cliente}")
    public void borrar(@PathVariable int id_cliente){
        ClienteRepository.delete(id_cliente);
    }
}
