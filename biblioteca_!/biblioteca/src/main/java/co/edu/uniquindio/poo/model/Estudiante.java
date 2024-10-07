package co.edu.uniquindio.poo.model;

public class Estudiante extends Persona {

    private double[] notas;

    public Estudiante(String nombre, String cedula, String telefono, String correo, double[] notas) {
        super(nombre, cedula, telefono, correo);
        this.notas = notas;
    }

    // Métodos Getters y Setters
    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularNotaMedia() {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", Nota Media: " + calcularNotaMedia();
    }

    public static void main(String[] args) {
        // Crear un objeto Estudiante con datos de ejemplo
        double[] notas = {4.5, 3.8, 4.2};
        Estudiante estudiante = new Estudiante("Juan Perez", "123456789", "3001234567", "juan.perez@uqvirtual.com", notas);

        // Mostrar la información del estudiante
        System.out.println(estudiante.mostrarInformacion());
    }
}
