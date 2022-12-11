package dbd.LAB.crud.models;

public class Empresa {
    private int id_empresa;
    private String pass;
    private String mail;
    private String direccion;
    private int idRanking;

    //Contruxtors

    public Empresa(int idEmpresa, String pass, String mail, String direccion, int idRanking) {
        this.id_empresa = idEmpresa;
        this.pass = pass;
        this.mail = mail;
        this.direccion = direccion;
        this.idRanking = idRanking;
    }

    //Getters

    public int getIdEmpresa() {
        return id_empresa;
    }

    public String getPass() {
        return pass;
    }

    public String getMail() {
        return mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getIdRanking() {
        return idRanking;
    }

    //Setters

    public void setIdEmpresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIdRanking(int idRanking) {
        this.idRanking = idRanking;
    }
}
