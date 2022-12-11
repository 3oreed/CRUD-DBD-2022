package dbd.LAB.crud.models;


public class Cliente {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String clave;
    private String email;
    private String direccion;
    private String fecha_nacimiento;
    private int edad;

    //Constructors

    public Cliente(int id_cliente, String nombre, String apellido,
                   String clave, String email, String direccion,
                   String fecha_nacimiento_, int edad) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.email = email;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento_;
        this.edad = edad;
    }
    //Getters
    public int getId_cliente() {
        return id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getClave() {
        return clave;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    //Setters

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
