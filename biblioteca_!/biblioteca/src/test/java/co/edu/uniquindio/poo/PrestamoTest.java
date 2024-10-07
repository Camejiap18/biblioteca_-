package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;
import java.util.List;
import co.edu.uniquindio.poo.model.Prestamo;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Bibliotecario;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.DetallePrestamo;

public class PrestamoTest {

    private Prestamo prestamo;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private Libro libro;
    private DetallePrestamo detalle;
    private List<DetallePrestamo> detalles;
    private Date fechaPrestamo;
    private Date fechaEntrega;

    @BeforeEach
    public void setUp() {
        // Inicializar el objeto Prestamo antes de cada prueba
        estudiante = new Estudiante("Maria Lopez", "1122334455", "3151234567", "maria.lopez@correo.com", new double[]{4.0, 3.5, 4.2});
        bibliotecario = new Bibliotecario("Carlos Ruiz", "2233445566", "3169876543", "carlos.ruiz@correo.com", 3000.0, 2015);
        libro = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 5, 150.0);
        detalle = new DetallePrestamo(libro, 1);
        detalles = List.of(detalle);
        fechaPrestamo = new Date();
        fechaEntrega = new Date(fechaPrestamo.getTime() + (1000L * 60 * 60 * 24 * 7)); // 7 días después
        prestamo = new Prestamo("P001", estudiante, bibliotecario, detalles, fechaPrestamo, fechaEntrega);
    }

    @Test
    public void pruebaMostrarInformacionPrestamo() {
        // Comprobar que la información del préstamo es correcta
        assertEquals("P001", prestamo.getCodigo());
        assertEquals(estudiante, prestamo.getEstudiante());
        assertEquals(detalles, prestamo.getDetalles());
        assertEquals(fechaPrestamo, prestamo.getFechaPrestamo());
        assertEquals(fechaEntrega, prestamo.getFechaEntrega());
    }

    @Test
    public void pruebaCalcularCosto() {
        // Comprobar que el cálculo del costo es correcto
        double costoEsperado = 7 * detalle.getSubtotal(); // 7 días * subtotal del detalle
        assertEquals(costoEsperado, prestamo.calcularCosto());
    }
}
