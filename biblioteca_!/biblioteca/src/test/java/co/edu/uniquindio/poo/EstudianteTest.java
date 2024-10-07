package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import co.edu.uniquindio.poo.model.Estudiante;

public class EstudianteTest {

    private Estudiante estudiante;

    @BeforeEach
    public void setUp() {
        // Inicializar el objeto Estudiante antes de cada prueba
        double[] notas = {4.0, 3.5, 4.2};
        estudiante = new Estudiante("Maria Lopez", "1122334455", "3151234567", "maria.lopez@correo.com", notas);
    }

    @Test
    public void pruebaMostrarInformacion() {
        // Comprobar que el método mostrarInformacion devuelve la información correcta
        assertEquals("Nombre: Maria Lopez, Cédula: 1122334455, Teléfono: 3151234567, Correo: maria.lopez@correo.com, Nota Media: 3.9", estudiante.mostrarInformacion());
    }

    @Test
    public void pruebaCalcularNotaMedia() {
        // Comprobar que el método calcularNotaMedia devuelve la nota media correcta
        assertEquals(3.9, estudiante.calcularNotaMedia());
    }
}
