package dbd.LAB.crud.models;

public class ProductoCategoria {
      private int idProdCat;
      private String nombrProdCat;
      private String desc;
      private int precio;
      private int initialStock;
      private int currentStock;
      private int vendidos;
      private int id_carrito;
      private int id_empresa;
      private int id_categoria;
    //Constructor
    public ProductoCategoria(int idProdCat, String nombrProdCat, String desc, int precio,
                             int initialStock, int currentStock, int vendidos, int id_carrito,
                             int id_empresa, int id_categoria) {
        this.idProdCat = idProdCat;
        this.nombrProdCat = nombrProdCat;
        this.desc = desc;
        this.precio = precio;
        this.initialStock = initialStock;
        this.currentStock = currentStock;
        this.vendidos = vendidos;
        this.id_carrito = id_carrito;
        this.id_empresa = id_empresa;
        this.id_categoria = id_categoria;
    }
    //Getters
    public int getIdProdCat() {
        return idProdCat;
    }

    public String getNombrProdCat() {
        return nombrProdCat;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrecio() {
        return precio;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public int getCurrentStock() {
        return currentStock;
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
    public void setIdProdCat(int idProdCat) {
        this.idProdCat = idProdCat;
    }

    public void setNombrProdCat(String nombrProdCat) {
        this.nombrProdCat = nombrProdCat;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
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
