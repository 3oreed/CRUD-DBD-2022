package dbd.LAB.crud.models;

public class Tienda {
    private int id_tienda;
    private String nombre;
    private int edad_minima;
    private String ciudad;
    private String tipo_empresa;
    private int id_empresa;

    //Constructor

    public Tienda(int id_tienda, String nombre, int edad_minima, String ciudad, String tipo_empresa, int id_empresa) {
        this.id_tienda = id_tienda;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.ciudad = ciudad;
        this.tipo_empresa = tipo_empresa;
        this.id_empresa = id_empresa;
    }

    //Getters

    public int getId_tienda() {
        return id_tienda;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTipo_empresa() {
        return tipo_empresa;
    }

    public int getId_empresa() {
        return id_empresa;
    }
    //Setters

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTipo_empresa(String tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }
}
