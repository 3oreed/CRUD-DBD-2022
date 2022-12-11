package dbd.LAB.crud.models;

public class ProductoCategoria {
      private int id_prod;
      private String nombre;
      private String descripcion;
      private int precio;
      private int stock_inicial;
      private int stock_actual;
      private int vendidos;
      private int id_carrito;
      private int id_empresa;
      private int id_categoria;
    //Constructor
    public ProductoCategoria(int id_prod, String nombre, String descripcion, int precio,
                             int stock_inicial, int stock_actual, int vendidos, int id_carrito,
                             int id_empresa, int id_categoria) {
        this.id_prod = id_prod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock_inicial = stock_inicial;
        this.stock_actual = stock_actual;
        this.vendidos = vendidos;
        this.id_carrito = id_carrito;
        this.id_empresa = id_empresa;
        this.id_categoria = id_categoria;
    }
    //Getters
    public int getId_prod() {
        return id_prod;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public int getVendidos() {
        return vendidos;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public int getId_categoria() {
        return id_categoria;
    }
    //Setters
    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
