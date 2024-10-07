package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import co.edu.uniquindio.poo.model.Bibliotecario;

public class BibliotecarioTest {

    private Bibliotecario bibliotecario;

    @BeforeEach
    public void setUp() {
        // Inicializar el objeto Bibliotecario antes de cada prueba con los parámetros correctos
        bibliotecario = new Bibliotecario("Carlos Ruiz", "2233445566", "3169876543", "carlos.ruiz@uqvirtual.com", 3000.0, 2015);
    }

    @Test
    public void pruebaMostrarInformacion() {
        // Comprobar que el método mostrarInformacion devuelve la información correcta
        assertEquals("Nombre: Carlos Ruiz, Cédula: 2233445566, Teléfono: 3169876543, Correo: carlos.ruiz@uqvirtual.com, Salario: 3000.0", bibliotecario.mostrarInformacion());
    }

    @Test
    public void pruebaCalcularSalarioTotal() {
        // Comprobar que el método calcularSalarioTotal devuelve el salario total correcto
        double salarioTotal = bibliotecario.calcularSalarioTotal(3, 15000.0);
        assertEquals(3600.0, salarioTotal);
    }
}
