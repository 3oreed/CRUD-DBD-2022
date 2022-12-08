package dbd.LAB.crud.models;

public class Administrador_Categoria_Empresa {
    private int  id_admin_categoria_empresa;
    private int id_admin ;
    private int  id_categoria;

    public Administrador_Categoria_Empresa(int id_admin_categoria_empresa, int id_admin, int id_categoria) {
        this.id_admin_categoria_empresa = id_admin_categoria_empresa;
        this.id_admin = id_admin;
        this.id_categoria = id_categoria;
    }

    public int getId_admin_categoria_empresa() {
        return id_admin_categoria_empresa;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_admin_categoria_empresa(int id_admin_categoria_empresa) {
        this.id_admin_categoria_empresa = id_admin_categoria_empresa;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
