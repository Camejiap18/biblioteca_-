package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import co.edu.uniquindio.poo.model.Libro;

public class LibroTest {

    private Libro libro;

    @BeforeEach
    public void setUp() {
        // Inicializar el objeto Libro antes de cada prueba
        libro = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 5, 150.0);
    }

    @Test
    public void pruebaMostrarInformacion() {
        // Comprobar que la información del libro es correcta
        assertEquals("001", libro.getCodigo());
        assertEquals("ISBN001", libro.getIsbn());
        assertEquals("Autor1", libro.getAutor());
        assertEquals("Titulo1", libro.getTitulo());
        assertEquals("Editorial1", libro.getEditorial());
        assertEquals("2023-01-01", libro.getFecha());
        assertEquals(5, libro.getUnidadesDisponibles());
        assertEquals(150.0, libro.getPrecio());
    }

    @Test
    public void pruebaActualizarUnidadesDisponibles() {
        // Comprobar que la actualización de unidades disponibles es correcta
        libro.actualizarUnidadesDisponibles(-1);
        assertEquals(4, libro.getUnidadesDisponibles());
        libro.actualizarUnidadesDisponibles(1);
        assertEquals(5, libro.getUnidadesDisponibles());
    }

    @Test
    public void pruebaPrestarYDevolver() {
        // Comprobar que los métodos prestar y devolver funcionan correctamente
        libro.prestar();
        assertEquals(4, libro.getUnidadesDisponibles());
        libro.devolver();
        assertEquals(5, libro.getUnidadesDisponibles());
    }
}
