package co.edu.uniquindio.poo.model;

public class Persona {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    public Persona(String nombre, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Métodos Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Método para mostrar la información de la persona
    public String mostrarInformacion() {
        return "Nombre: " + nombre + ", Cédula: " + cedula + ", Teléfono: " + telefono + ", Correo: " + correo;
    }

    public static void main(String[] args) {
        // Crear un objeto Persona con datos de ejemplo
        Persona persona = new Persona("Ana Gomez", "987654321", "3109876543", "ana.gomez@uqvirtual.com");

        // Mostrar la información de la persona
        System.out.println(persona.mostrarInformacion());
    }
}
