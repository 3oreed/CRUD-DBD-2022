package dbd.LAB.crud.models;

public class Empresa {
    private int id_empresa;
    private String nombre_empresa;
    private String clave;
    private String mail;
    private String direccion;
    private int id_ranking;

    //Contruxtors

    public Empresa(int id_empresa, String nombre_empresa, String clave, String mail, String direccion, int id_ranking) {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.clave = clave;
        this.mail = mail;
        this.direccion = direccion;
        this.id_ranking = id_ranking;
    }


    //Getters

    public int getIdEmpresa() {
        return id_empresa;
    }

    public String getClave() {
        return clave;
    }

    public String getMail() {
        return mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getId_ranking() {
        return id_ranking;
    }

    //Setters

    public void setIdEmpresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }
}
