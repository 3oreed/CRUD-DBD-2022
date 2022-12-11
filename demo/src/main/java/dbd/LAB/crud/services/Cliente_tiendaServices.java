package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Cliente_tienda;
import dbd.LAB.crud.repositories.Cliente_tiendaRepository;

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
public class Cliente_tiendaServices {

    private final Cliente_tiendaRepository Cliente_tiendaRepository;

    Cliente_tiendaServices(Cliente_tiendaRepository Cliente_tiendaRepository){
        this.Cliente_tiendaRepository = Cliente_tiendaRepository;
    }



    // crear C
    @PostMapping("/Cliente_tienda")
    @ResponseBody
    public Cliente_tienda crear(@RequestBody Cliente_tienda Cliente_tienda){
        Cliente_tienda resultado = Cliente_tiendaRepository.crear(Cliente_tienda);
        return resultado;
    }



    // get R
    @GetMapping("/Cliente_tienda")
    public List<Cliente_tienda> getAllCliente_tiendas(){
        return Cliente_tiendaRepository.getAll();
    }
    //get by
    @GetMapping("/Cliente_tienda/{id}")
    public List<Cliente_tienda> getCategoria(@PathVariable int id){
        return Cliente_tiendaRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Categoria/{precio}") //{id}(?)
    @ResponseBody
    public String updateCliente_tienda(@RequestBody Cliente_tienda Cliente_tienda, @PathVariable int id){
        String retorno = Cliente_tiendaRepository.update(Cliente_tienda,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Categoria/{id}")
    public void borrar(@PathVariable int id){
        Cliente_tiendaRepository.delete(id);
    }
}
