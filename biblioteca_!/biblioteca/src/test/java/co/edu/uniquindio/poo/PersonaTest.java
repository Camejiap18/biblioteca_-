package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import co.edu.uniquindio.poo.model.Persona;

public class PersonaTest {

    private Persona persona;

    @BeforeEach
    public void setUp() {
        // Inicializar el objeto Persona antes de cada prueba
        persona = new Persona("Ana Gomez", "987654321", "3109876543", "ana.gomez@uqvirtual.com");
    }

    @Test
    public void pruebaMostrarInformacion() {
        // Comprobar que el método mostrarInformacion devuelve la información correcta
        assertEquals("Nombre: Ana Gomez, Cédula: 987654321, Teléfono: 3109876543, Correo: ana.gomez@uqvirtual.com", persona.mostrarInformacion());
    }

    @Test
    public void pruebaGetters() {
        // Comprobar que los métodos getters devuelven los valores correctos
        assertEquals("Ana Gomez", persona.getNombre());
        assertEquals("987654321", persona.getCedula());
        assertEquals("3109876543", persona.getTelefono());
        assertEquals("ana.gomez@correo.com", persona.getCorreo());
    }

    @Test
    public void pruebaSetters() {
        // Comprobar que los métodos setters funcionan correctamente
        persona.setNombre("Carlos Ruiz");
        persona.setCedula("123456789");
        persona.setTelefono("3001234567");
        persona.setCorreo("carlos.ruiz@correo.com");

        assertEquals("Carlos Ruiz", persona.getNombre());
        assertEquals("123456789", persona.getCedula());
        assertEquals("3001234567", persona.getTelefono());
        assertEquals("carlos.ruiz@correo.com", persona.getCorreo());
    }
}
