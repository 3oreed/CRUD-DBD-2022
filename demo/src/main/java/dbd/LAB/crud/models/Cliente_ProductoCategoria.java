package dbd.LAB.crud.models;

public class Cliente_ProductoCategoria {
    private int id_cliente_productoCategoria;
    private int id_cliente;
    private int prodCat;

    //Contructors

    public Cliente_ProductoCategoria(int id_cliente_productoCategoria, int id_cliente, int prodCat) {
        this.id_cliente_productoCategoria = id_cliente_productoCategoria;
        this.id_cliente = id_cliente;
        this.prodCat = prodCat;
    }
    //Getters
    public int getId_cliente_productoCategoria() {
        return id_cliente_productoCategoria;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getProdCat() {
        return prodCat;
    }
    //Setters

    public void setId_cliente_productoCategoria(int id_cliente_productoCategoria) {
        this.id_cliente_productoCategoria = id_cliente_productoCategoria;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setProdCat(int prodCat) {
        this.prodCat = prodCat;
    }
}