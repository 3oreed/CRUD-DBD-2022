package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Cliente_ProductoCategoria;
import dbd.LAB.crud.repositories.Cliente_ProductoCategoriaRepository;

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
public class Cliente_ProductoCategoriaServices {

    private final Cliente_ProductoCategoriaRepository Cliente_ProductoCategoriaRepository;

    Cliente_ProductoCategoriaServices(Cliente_ProductoCategoriaRepository Cliente_ProductoCategoriaRepository){
        this.Cliente_ProductoCategoriaRepository = Cliente_ProductoCategoriaRepository;
    }



    // crear C
    @PostMapping("/Cliente_ProductoCategoria")
    @ResponseBody
    public Cliente_ProductoCategoria crear(@RequestBody Cliente_ProductoCategoria Cliente_ProductoCategoria){
        Cliente_ProductoCategoria resultado = Cliente_ProductoCategoriaRepository.crear(Cliente_ProductoCategoria);
        return resultado;
    }



    // get R
    @GetMapping("/Cliente_ProductoCategoria")
    public List<Cliente_ProductoCategoria> getAllCliente_ProductoCategorias(){
        return Cliente_ProductoCategoriaRepository.getAll();
    }
    //get by
    @GetMapping("/Cliente_ProductoCategoria/{id}")
    public List<Cliente_ProductoCategoria> getCategoria(@PathVariable int id){
        return Cliente_ProductoCategoriaRepository.show(id);
    }



    // actualizar U
    @PutMapping("/Categoria/{precio}") //{id}(?)
    @ResponseBody
    public String updateCliente_ProductoCategoria(@RequestBody Cliente_ProductoCategoria Cliente_ProductoCategoria, @PathVariable int id){
        String retorno = Cliente_ProductoCategoriaRepository.update(Cliente_ProductoCategoria,id);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/Categoria/{id}")
    public void borrar(@PathVariable int id){
        Cliente_ProductoCategoriaRepository.delete(id);
    }
}
