package dbd.LAB.crud.models;

    public class Administrador {
        private String id_admin;
        private String clave;
        private String email;
        private String nombre;
        private String apellido;


        // Constructor
        public Administrador(String id_admin, String clave, String email, String nombre, String apellido) {
            this.id_admin = id_admin;
            this.clave = clave;
            this.email = email;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getId_admin() {
            return id_admin;
        }

        public String getClave() {
            return clave;
        }

        public String getEmail() {
            return email;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setId_admin(String id_admin) {
            this.id_admin = id_admin;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
    }


