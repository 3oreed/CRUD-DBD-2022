package dbd.LAB.crud.models;

public class Empresa_Administrador {

    private Integer id_empresa_Administrador;
    private int id_empresa;
    private int id_administrador;


    // Contructor
    public Empresa_Administrador(int id_empresa_Administrador, int id_empresa, int id_administrador){
        this.id_empresa_Administrador = id_empresa_Administrador;
        this.id_empresa = id_empresa;
        this.id_administrador = id_administrador;
    }

    //Getters
    public int getId_empresa_Administrador() {
        return id_empresa_Administrador;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    //Setters
    public void setId_empresa_Administrador(int id_empresa_Administrador) {
        this.id_empresa_Administrador = id_empresa_Administrador;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }
}
