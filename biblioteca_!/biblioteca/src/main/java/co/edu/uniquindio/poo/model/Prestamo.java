package co.edu.uniquindio.poo.model;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Prestamo {
    private String codigo;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private List<DetallePrestamo> detalles;
    private Date fechaPrestamo;
    private Date fechaEntrega;

    public Prestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario, List<DetallePrestamo> detalles, Date fechaPrestamo, Date fechaEntrega) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
        this.detalles = detalles;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public List<DetallePrestamo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePrestamo> detalles) {
        this.detalles = detalles;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    // Método que calcula el costo total del préstamo
    public double calcularCosto() {
        long dias = TimeUnit.DAYS.convert(fechaEntrega.getTime() - fechaPrestamo.getTime(), TimeUnit.MILLISECONDS);
        double costo = 0;
        for (DetallePrestamo detalle : detalles) {
            costo += detalle.getSubtotal();
        }
        return costo * dias;
    }

    public static void main(String[] args) {
        // Crear un objeto Prestamo con datos de ejemplo
        Estudiante estudiante = new Estudiante("Maria Lopez", "1122334455", "3151234567", "maria.lopez@uqvirtual.com", new double[]{4.0, 3.5, 4.2});
        Bibliotecario bibliotecario = new Bibliotecario("Carlos Ruiz", "2233445566", "3169876543", "carlos.ruiz@uqvirtual.com", 3000.0, 2015);
        Libro libro = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 5, 150.0);
        DetallePrestamo detalle = new DetallePrestamo(libro, 1);
        List<DetallePrestamo> detalles = List.of(detalle);
        Date fechaPrestamo = new Date();
        Date fechaEntrega = new Date(fechaPrestamo.getTime() + (1000L * 60 * 60 * 24 * 7)); // 7 días después
        Prestamo prestamo = new Prestamo("P001", estudiante, bibliotecario, detalles, fechaPrestamo, fechaEntrega);

        // Mostrar la información del préstamo
        System.out.println("Código: " + prestamo.getCodigo() + ", Estudiante: " + prestamo.getEstudiante().mostrarInformacion() + ", Bibliotecario: " + prestamo.getBibliotecario().mostrarInformacion() + ", Fecha de Préstamo: " + prestamo.getFechaPrestamo() + ", Fecha de Entrega: " + prestamo.getFechaEntrega() + ", Costo Total: " + prestamo.calcularCosto());
    }
}
