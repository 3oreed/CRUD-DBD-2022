package dbd.LAB.crud.repositories;

import dbd.LAB.crud.models.Categoria;

import java.util.List;

public interface CCategoriaRepository {
    /**
    * Inserta un Categoria en la tabla Categoria.
    * Al ser el todos sus atributos obligatorios (excepto id), si son nulos o vacíos se lanzará
    * una excepción o si la conexion falla .
    *
    * @param Categoria objeto de la clase Categoria que tiene los atributos correspondientes a insertar como Categoria.
    * @return retorna un Categoria que contiene el Categoria creado o null si se lanza excepcion.
    * @throws Exception Si uno de los atributos es null o vacio.
    */
    public Categoria crear(Categoria Categoria);

    /**
    * Inserta datos en un Categoria en la tabla Categoria.
    * Al ser el todos sus atributos obligatorios (excepto id), si son nulos o vacíos se lanzará
    * una excepción, si la conexion falla o si no encuentra el id.
    *
    * @param Categoria objeto de la clase Categoria que tiene los atributos correspondientes a insertar en un Categoria.
    * @param id string alfanumerico correspondiente al id del Categoria al cual se desea insertar datos.
    * @return retorna un string que indica el exito de la actualización de los datos.
    * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el id.
    */
    public String update(Categoria Categoria, String id);


    /**
    * Lista todos los Categorias de la base de datos ascendente por nombre.
    * Si la conexion falla lanzará excepción.
    *
    * @return retorna una lista de Categoria que contiene los Categorias o null si se lanza excepcion.
    * @throws Exception Si la conexion falla.
    */
    public List<Categoria> getAll();


    /**
    * Lista un Categoria con un id especifico de la base de datos.
    * Si la conexion falla o si no encuentra el id lanzará excepción.
    *
    * @param id identificador del Categoria que se desea mostrar.
    * @return retorna una lista de Categoria que contiene el Categoria con el id solicitado o null si se lanza excepcion.
    * @throws Exception Si la conexion falla o si no encuentra el id.
    */
    public List<Categoria> show(String id);



    /**
    * Elimina un Categoria de la base de datos por su id.
    * Si la conexion falla o si no encuentra el id lanzará excepción.
    *
    * @param id identificador del Categoria que se desea eliminar.
    * @throws Exception Si la conexion falla o si no encuentra el id.
    */
    public void delete(String id);
}