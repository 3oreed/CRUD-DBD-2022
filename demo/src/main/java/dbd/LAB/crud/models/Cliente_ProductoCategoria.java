package dbd.LAB.crud.models;

public class Cliente_ProductoCategoria {
    private int cliente_productocategoria;
    private int id_cliente;
    private int id_prod;

    //Contructors

    public Cliente_ProductoCategoria(int cliente_productocategoria, int id_cliente, int id_prod) {
        this.cliente_productocategoria = cliente_productocategoria;
        this.id_cliente = id_cliente;
        this.id_prod = id_prod;
    }
    //Getters
    public int getCliente_productocategoria() {
        return cliente_productocategoria;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_prod() {
        return id_prod;
    }
    //Setters

    public void setCliente_productocategoria(int cliente_productocategoria) {
        this.cliente_productocategoria = cliente_productocategoria;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }
}