package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import co.edu.uniquindio.poo.model.*;

public class BibliotecaTest {

    private static final Logger LOGGER = Logger.getLogger(BibliotecaTest.class.getName());
    private Biblioteca adminBiblioteca;

    @BeforeEach
    public void configuracionInicial() {
        adminBiblioteca = new Biblioteca("Biblioteca Central");
    }

    @Test
    public void pruebaBuscarLibroPorCodigo() {
        LOGGER.info("Iniciando prueba para buscar un libro por código");
        adminBiblioteca.registrarLibro("004", "ISBN004", "Autor4", "Titulo4", "Editorial4", "2023-01-01", 5, 150.0);
        Libro libro = adminBiblioteca.buscarLibroPorCodigo("004");
        assertNotNull(libro);
        assertEquals("Titulo4", libro.getTitulo());
        LOGGER.info("Finalizando prueba para buscar un libro por código");
    }

    @Test
    public void pruebaBuscarEstudiantePorCedula() {
        LOGGER.info("Iniciando prueba para buscar un estudiante por cédula");
        double[] notas = {3.5, 4.0, 4.2};
        adminBiblioteca.registrarEstudiante("Ana", "321", "321654", "ana@uqvirtual.com", notas);
        Estudiante estudiante = adminBiblioteca.buscarEstudiantePorCedula("321");
        assertNotNull(estudiante);
        assertEquals("Ana", estudiante.getNombre());
        LOGGER.info("Finalizando prueba para buscar un estudiante por cédula");
    }
    

    @Test
    public void pruebaCantidadPrestamosPorNombre() {
        LOGGER.info("Iniciando prueba para cantidad de préstamos por nombre de libro");
        double[] notas = {3.2, 4.1, 3.8};
        Estudiante estudiante = new Estudiante("Luis", "987", "987654", "luis@uqvirtual.com", notas);
        Libro libro = new Libro("005", "ISBN005", "Autor5", "Titulo5", "Editorial5", "2023-01-01", 10, 200.0);
    
        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));
    
        adminBiblioteca.registrarPrestamo("P004", estudiante, detalles, new Date(), new Date());
        adminBiblioteca.registrarPrestamo("P005", estudiante, detalles, new Date(), new Date());
    
        int cantidad = adminBiblioteca.buscarCantidadPrestamosPorNombre("Titulo5");
        assertEquals(2, cantidad);
        LOGGER.info("Finalizando prueba para cantidad de préstamos por nombre de libro");
    }
    

    @Test
    public void pruebaReemplazarLibro() {
        LOGGER.info("Iniciando prueba para reemplazar un libro");
        adminBiblioteca.registrarLibro("006", "ISBN006", "Autor6", "Titulo6", "Editorial6", "2023-01-01", 5, 150.0);
        Libro libroModificado = new Libro("006", "ISBN006", "Autor6", "NuevoTitulo6", "Editorial6", "2023-01-01", 5, 150.0);
        adminBiblioteca.reemplazarLibro("006", libroModificado);
        Libro libro = adminBiblioteca.buscarLibroPorCodigo("006");
        assertEquals("NuevoTitulo6", libro.getTitulo());
        LOGGER.info("Finalizando prueba para reemplazar un libro");
    }

    @Test
    public void pruebaRegistrarPrestamo() {
        LOGGER.info("Iniciando prueba para registrar un préstamo");
        double[] notas = {4.0, 3.6, 4.2};
        Estudiante estudiante = new Estudiante("Pedro", "654", "654987", "pedro@example.com", notas);
        Libro libro = new Libro("007", "ISBN007", "Autor7", "Titulo7", "Editorial7", "2023-01-01", 10, 200.0);
    
        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));
    
        adminBiblioteca.registrarPrestamo("P006", estudiante, detalles, new Date(), new Date());
        Prestamo prestamo = adminBiblioteca.buscarPrestamoPorCodigo("P006");
        assertNotNull(prestamo);
        assertEquals(estudiante, prestamo.getEstudiante());
        LOGGER.info("Finalizando prueba para registrar un préstamo");
    }
    

    @Test
    public void pruebaAgregarLibroPrestamo() {
        LOGGER.info("Iniciando prueba para agregar un libro a un préstamo");
        double[] notas = {3.5, 3.8, 4.0};
        Estudiante estudiante = new Estudiante("Laura", "852", "852963", "laura@example.com", notas);
        Libro libro1 = new Libro("008", "ISBN008", "Autor8", "Titulo8", "Editorial8", "2023-01-01", 10, 200.0);
        Libro libro2 = new Libro("009", "ISBN009", "Autor9", "Titulo9", "Editorial9", "2023-01-01", 10, 200.0);
    
        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro1, 1));
    
        adminBiblioteca.registrarPrestamo("P007", estudiante, detalles, new Date(), new Date());
        adminBiblioteca.agregarLibroPrestamo("P007", new DetallePrestamo(libro2, 1));
    
        Prestamo prestamo = adminBiblioteca.buscarPrestamoPorCodigo("P007");
        assertEquals(2, prestamo.getDetalles().size());
        LOGGER.info("Finalizando prueba para agregar un libro a un préstamo");
    }
    

    @Test
    public void pruebaDevolverPrestamo() {
        LOGGER.info("Iniciando prueba para devolver un préstamo");
        double[] notas = {3.7, 4.0, 3.9};
        Estudiante estudiante = new Estudiante("Sofia", "963", "963852", "sofia@example.com", notas);
        Libro libro = new Libro("010", "ISBN010", "Autor10", "Titulo10", "Editorial10", "2023-01-01", 10, 200.0);
    
        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));
    
        adminBiblioteca.registrarPrestamo("P008", estudiante, detalles, new Date(), new Date());
        double costo = adminBiblioteca.devolverPrestamo("P008", new Date());
        assertTrue(costo > 0);
        LOGGER.info("Finalizando prueba para devolver un préstamo");
    }
    

    @Test
    public void pruebaBuscarPrestamoPorCodigo() {
        LOGGER.info("Iniciando prueba para buscar un préstamo por código");
        double[] notas = {3.8, 3.9, 4.1};
        Estudiante estudiante = new Estudiante("Miguel", "741", "741852", "miguel@example.com", notas);
        Libro libro = new Libro("011", "ISBN011", "Autor11", "Titulo11", "Editorial11", "2023-01-01", 10, 200.0);
    
        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));
    
        adminBiblioteca.registrarPrestamo("P009", estudiante, detalles, new Date(), new Date());
        Prestamo prestamo = adminBiblioteca.buscarPrestamoPorCodigo("P009");
        assertNotNull(prestamo);
        assertEquals("P009", prestamo.getCodigo());
        LOGGER.info("Finalizando prueba para buscar un préstamo por código");
    }
    

    @Test
    public void pruebaEstudianteConMasPrestamos() {
        LOGGER.info("Iniciando prueba para encontrar el estudiante con más préstamos");
        double[] notas1 = {3.8, 4.0, 3.9};
        Estudiante estudiante1 = new Estudiante("Juan", "123", "123456", "juan@example.com", notas1);
        double[] notas2 = {3.7, 4.1, 3.6};
        Estudiante estudiante2 = new Estudiante("Maria", "456", "654321", "maria@example.com", notas2);
    
        Libro libro1 = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 10, 100.0);
        Libro libro2 = new Libro("002", "ISBN002", "Autor2", "Titulo2", "Editorial2", "2023-01-01", 10, 100.0);
    
        List<DetallePrestamo> detalles1 = new ArrayList<>();
        detalles1.add(new DetallePrestamo(libro1, 1));
        detalles1.add(new DetallePrestamo(libro2, 1));
    
        List<DetallePrestamo> detalles2 = new ArrayList<>();
        detalles2.add(new DetallePrestamo(libro1, 1));
    
        adminBiblioteca.registrarPrestamo("P001", estudiante1, detalles1, new Date(), new Date());
        adminBiblioteca.registrarPrestamo("P002", estudiante1, detalles2, new Date(), new Date());
        adminBiblioteca.registrarPrestamo("P003", estudiante2, detalles1, new Date(), new Date());
    
        Estudiante estudianteConMasPrestamos = adminBiblioteca.estudianteConMasPrestamos();
        assertEquals(estudiante1, estudianteConMasPrestamos);
        LOGGER.info("Finalizando prueba para encontrar el estudiante con más préstamos");
    }
    

    @Test
    public void pruebaTotalDineroRecaudado() {
        LOGGER.info("Iniciando prueba para calcular el total de dinero recaudado");
        double[] notas = {3.9, 4.0, 4.1};
        Estudiante estudiante = new Estudiante("Lucia", "159", "159753", "lucia@example.com", notas);
        Libro libro = new Libro("012", "ISBN012", "Autor12", "Titulo12", "Editorial12", "2023-01-01", 10, 200.0);
    
        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));
    
        adminBiblioteca.registrarPrestamo("P010", estudiante, detalles, new Date(), new Date());
        adminBiblioteca.devolverPrestamo("P010", new Date());
    
        double total = adminBiblioteca.totalDineroRecaudado();
        assertTrue(total > 0);
        assertEquals(200.0, total);
        LOGGER.info("Finalizando prueba para calcular el total de dinero recaudado");
    }
    

    @Test
    public void pruebaTotalDineroAPagarBibliotecarios() {
        LOGGER.info("Iniciando prueba para calcular el total de dinero a pagar a los bibliotecarios");
        adminBiblioteca.registrarBibliotecario("Carlos", "123", "123456", "carlos@example.com", 1000.0, 2015);
        adminBiblioteca.registrarBibliotecario("Ana", "456", "654321", "ana@example.com", 1200.0, 2018);
    
        double[] notas = {3.6, 3.8, 4.2};
        Estudiante estudiante = new Estudiante("Luis", "789", "789456", "luis@example.com", notas);
        Libro libro = new Libro("013", "ISBN013", "Autor13", "Titulo13", "Editorial13", "2023-01-01", 10, 200.0);
    
        List<DetallePrestamo> detalles = new ArrayList<>();
        detalles.add(new DetallePrestamo(libro, 1));
    
        adminBiblioteca.registrarPrestamo("P011", estudiante, detalles, new Date(), new Date());
        adminBiblioteca.devolverPrestamo("P011", new Date());
    
        double total = adminBiblioteca.totalDineroAPagarBibliotecarios();
        assertTrue(total > 0);
        assertEquals(2200.0, total);
        LOGGER.info("Finalizando prueba para calcular el total de dinero a pagar a los bibliotecarios");
    }
    
}