import dbd.LAB.crud.models.Cliente;
import dbd.LAB.crud.repositories.ClienteRepository;

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

    ClienteService(ClienteRepository ClienteRepository){
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
    @GetMapping("/Cliente/{id}")
    public List<Cliente> getCategoria(@PathVariable int id){
        return ClienteRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Categoria/{precio}") //{id}(?)
    @ResponseBody
    public String updateCliente(@RequestBody Cliente Cliente, @PathVariable int id){
        String retorno = ClienteRepository.update(Cliente,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Categoria/{id}")
    public void borrar(@PathVariable int id){
        ClienteRepository.delete(id);
    }
}
