package dbd.LAB.crud.models;

public class ProductoCarrito {
    private int idItem;
    private String nombreItem;
    private int cantItem;
    private String comentario;
    //Constructor

    public ProductoCarrito(int idItem, String nombreItem, int cantItem, String comentario) {
        this.idItem = idItem;
        this.nombreItem = nombreItem;
        this.cantItem = cantItem;
        this.comentario = comentario;
    }
    //Getters

    public int getIdItem() {
        return idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public int getCantItem() {
        return cantItem;
    }

    public String getComentario() {
        return comentario;
    }
    //Setters

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public void setCantItem(int cantItem) {
        this.cantItem = cantItem;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
