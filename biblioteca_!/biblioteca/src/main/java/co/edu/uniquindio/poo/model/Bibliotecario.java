package co.edu.uniquindio.poo.model;

public class Bibliotecario extends Persona {
    
    private double salario;
    private int anoIngreso;

    public Bibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int anoIngreso) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        this.anoIngreso = anoIngreso;
    }

    // Métodos Getters y Setters específicos de Bibliotecario
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnoIngreso() {
        return anoIngreso;
    }

    public void setAnoIngreso(int anoIngreso) {
        this.anoIngreso = anoIngreso;
    }

    public double calcularSalarioTotal(int añosAntiguedad, double totalPrestamos) {
        double comision = totalPrestamos * 0.2;
        double bonificacion = comision * 0.02 * añosAntiguedad;
        return salario + comision + bonificacion;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", Salario: " + salario;
    }

    public static void main(String[] args) {
        // Crear un objeto Bibliotecario con datos de ejemplo
        Bibliotecario bibliotecario = new Bibliotecario("Carlos Ruiz", "2233445566", "3169876543", "carlos.ruiz@uqvirtual.com", 3000.0, 2015);

        // Calcular y mostrar el salario total del bibliotecario
        double salarioTotal = bibliotecario.calcularSalarioTotal(3, 15000.0);
        System.out.println("Salario Total: " + salarioTotal);

        // Mostrar la información del bibliotecario
        System.out.println(bibliotecario.mostrarInformacion());
    }
}
