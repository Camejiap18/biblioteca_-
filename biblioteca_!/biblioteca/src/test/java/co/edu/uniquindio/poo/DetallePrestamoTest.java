package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import co.edu.uniquindio.poo.model.DetallePrestamo;
import co.edu.uniquindio.poo.model.Libro;

public class DetallePrestamoTest {

    private DetallePrestamo detalle;
    private Libro libro;

    @BeforeEach
    public void setUp() {
        // Inicializar el objeto DetallePrestamo antes de cada prueba
        libro = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 5, 150.0);
        detalle = new DetallePrestamo(libro, 2);
    }

    @Test
    public void pruebaMostrarInformacionDetallePrestamo() {
        // Comprobar que la información del detalle del préstamo es correcta
        assertEquals(libro, detalle.getLibro());
        assertEquals(2, detalle.getCantidad());
        assertEquals(300.0, detalle.getSubtotal());
    }

    @Test
    public void pruebaCalcularSubtotal() {
        // Comprobar que el cálculo del subtotal es correcto
        detalle.setCantidad(3);
        assertEquals(450.0, detalle.getSubtotal());
    }

    @Test
    public void pruebaSetters() {
        // Comprobar que los métodos setters funcionan correctamente
        Libro nuevoLibro = new Libro("002", "ISBN002", "Autor2", "Titulo2", "Editorial2", "2023-02-01", 10, 200.0);
        detalle.setLibro(nuevoLibro);
        detalle.setCantidad(4);

        assertEquals(nuevoLibro, detalle.getLibro());
        assertEquals(4, detalle.getCantidad());
        assertEquals(800.0, detalle.getSubtotal());
    }
}
