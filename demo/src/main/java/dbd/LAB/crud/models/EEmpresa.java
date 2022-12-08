package dbd.LAB.crud.models;

public class Empresa {
    private int idEmpresa;
    private String pass;
    private String mail;
    private String direccion;
    private int idRanking;

    public Empresa(int idEmpresa, String pass, String mail, String direccion, int idRanking) {
        this.idEmpresa = idEmpresa;
        this.pass = pass;
        this.mail = mail;
        this.direccion = direccion;
        this.idRanking = idRanking;
    }

    public int getIdEmpresa() {
        return idEmpresa;
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

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
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
