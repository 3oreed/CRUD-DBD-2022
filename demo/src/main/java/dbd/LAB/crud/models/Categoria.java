
package dbd.LAB.crud.models;

public class Categoria {
    private int id_categoria;
    private String nombre;
    private String descripcion;
    private int id_tienda;

    //Constructors

    public Categoria(int id_categoria, String nombre, String descripcion, int id_tienda) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_tienda = id_tienda;
    }
    //Getters
    public int getId_categoria() {
        return id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    //Setters

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }
}
