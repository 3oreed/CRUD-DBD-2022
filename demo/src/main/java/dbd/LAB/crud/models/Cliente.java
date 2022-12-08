package dbd.LAB.crud.models;


public class Cliente {
    private int Id_cliente;
    private String Nombre_cliente;
    private String Apellido_cliente;
    private String Clave_cliente;
    private String Email_cliente;
    private String Direccion_cliente;
    private String Fecha_nacimiento_cliente;
    private int Edad_cliente;

    //Constructors

    public Cliente(int id_cliente, String nombre_cliente, String apellido_cliente,
                   String clave_cliente, String email_cliente, String direccion_cliente,
                   String fecha_nacimiento_cliente, int edad_cliente) {
        this.Id_cliente = id_cliente;
        this.Nombre_cliente = nombre_cliente;
        this.Apellido_cliente = apellido_cliente;
        this.Clave_cliente = clave_cliente;
        this.Email_cliente = email_cliente;
        this.Direccion_cliente = direccion_cliente;
        this.Fecha_nacimiento_cliente = fecha_nacimiento_cliente;
        this.Edad_cliente = edad_cliente;
    }
    //Getters
    public int getId_cliente() {
        return Id_cliente;
    }

    public String getNombre_cliente() {
        return Nombre_cliente;
    }

    public String getApellido_cliente() {
        return Apellido_cliente;
    }

    public String getClave_cliente() {
        return Clave_cliente;
    }

    public String getEmail_cliente() {
        return Email_cliente;
    }

    public String getDireccion_cliente() {
        return Direccion_cliente;
    }

    public String getFecha_nacimiento_cliente() {
        return Fecha_nacimiento_cliente;
    }

    public int getEdad_cliente() {
        return Edad_cliente;
    }

    //Setters

    public void setId_cliente(int id_cliente) {
        Id_cliente = id_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        Nombre_cliente = nombre_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        Apellido_cliente = apellido_cliente;
    }

    public void setClave_cliente(String clave_cliente) {
        Clave_cliente = clave_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        Email_cliente = email_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        Direccion_cliente = direccion_cliente;
    }

    public void setFecha_nacimiento_cliente(String fecha_nacimiento_cliente) {
        Fecha_nacimiento_cliente = fecha_nacimiento_cliente;
    }

    public void setEdad_cliente(int edad_cliente) {
        Edad_cliente = edad_cliente;
    }
}
