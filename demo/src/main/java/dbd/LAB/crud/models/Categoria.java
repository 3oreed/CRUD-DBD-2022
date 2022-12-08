
package dbd.LAB.crud.models;

public class Categoria {
    private int id_categoria;
    private String nombreCategoria;
    private String Descripcion;
    private int id_tienda;

    //Constructors

    public Categoria(int id_categoria, String nombreCategoria, String descripcion, int id_tienda) {
        this.id_categoria = id_categoria;
        this.nombreCategoria = nombreCategoria;
        this.Descripcion = descripcion;
        this.id_tienda = id_tienda;
    }
    //Getters
    public int getId_categoria() {
        return id_categoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    //Setters

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }
}
