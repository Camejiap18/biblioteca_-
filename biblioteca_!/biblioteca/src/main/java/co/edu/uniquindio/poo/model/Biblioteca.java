package co.edu.uniquindio.poo.model;
import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {

    private String nombre;
    private List<Bibliotecario> listaBibliotecarios = new ArrayList<>();
    private List<Estudiante> listaEstudiantes = new ArrayList<>();
    private Map<String, Libro> mapaLibros = new HashMap<>();
    private Map<String, Prestamo> mapaPrestamos = new HashMap<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    // Métodos Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public Map<String, Libro> getMapaLibros() {
        return mapaLibros;
    }

    public Map<String, Prestamo> getMapaPrestamos() {
        return mapaPrestamos;
    }

    //Método para registrar un Libro
    public void registrarLibro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles, double precio) {
        mapaLibros.put(codigo, new Libro(codigo, isbn, autor, titulo, editorial, fecha, unidadesDisponibles, precio));
    }

    // Método para registrar un bibliotecario
    public void registrarBibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int anoIngreso){
        listaBibliotecarios.add(new Bibliotecario(nombre, cedula, telefono, correo, salario, anoIngreso));
    }
    
    // Método para registrar un estudiante
    public void registrarEstudiante(String nombre, String cedula, String telefono, String correo, double[] notas) {
        listaEstudiantes.add(new Estudiante(nombre, cedula, telefono, correo, notas));
    }

    // Método para agregar un bibliotecario
    public void agregarBibliotecario(String nombre, String cedula, String telefono, String correo, double salario, int anoIngreso) {
        listaBibliotecarios.add(new Bibliotecario(nombre, cedula, telefono, correo, salario, anoIngreso));
    }

    // Método para agregar un estudiante
    public void agregarEstudiante(String nombre, String cedula, String telefono, String correo, double[] notas) {
        listaEstudiantes.add(new Estudiante(nombre, cedula, telefono, correo, notas));
    }

    // Método para agregar un libro
    public void agregarLibro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles, double precio) {
        mapaLibros.put(codigo, new Libro(codigo, isbn, autor, titulo, editorial, fecha, unidadesDisponibles, precio));
    }

    // Método para buscar un libro por su código
    public Libro buscarLibroPorCodigo(String codigo) {
        return mapaLibros.get(codigo);
    }

    // Método para buscar un estudiante por su cédula
    public Estudiante buscarEstudiantePorCedula(String cedula) {
        return listaEstudiantes.stream()
                .filter(estudiante -> estudiante.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    // Método para buscar la cantidad de préstamos de un libro por su nombre
    public int buscarCantidadPrestamosPorNombre(String nombre) {
        return (int) mapaPrestamos.values().stream()
                .flatMap(prestamo -> prestamo.getDetalles().stream())
                .filter(detalle -> detalle.getLibro().getTitulo().equals(nombre))
                .count();
    }

    // Método para reemplazar un libro
    public void reemplazarLibro(String codigo, Libro nuevoLibro) {
        mapaLibros.put(codigo, nuevoLibro);
    }

    // Método para registrar un préstamo sin bibliotecario
    public void registrarPrestamo(String codigo, Estudiante estudiante, List<DetallePrestamo> detalles, Date fechaPrestamo, Date fechaEntrega) {
        Prestamo prestamo = new Prestamo(codigo, estudiante, null, detalles, fechaPrestamo, fechaEntrega);
        mapaPrestamos.put(codigo, prestamo);
        detalles.forEach(detalle -> detalle.getLibro().actualizarUnidadesDisponibles(-detalle.getCantidad()));
    }

    // Método para registrar un préstamo con bibliotecario
    public void registrarPrestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario, List<DetallePrestamo> detalles, Date fechaPrestamo, Date fechaEntrega) {
        Prestamo prestamo = new Prestamo(codigo, estudiante, bibliotecario, detalles, fechaPrestamo, fechaEntrega);
        mapaPrestamos.put(codigo, prestamo);
        detalles.forEach(detalle -> detalle.getLibro().actualizarUnidadesDisponibles(-detalle.getCantidad()));
    }

    // Método para agregar un libro a un préstamo
    public void agregarLibroPrestamo(String codigoPrestamo, DetallePrestamo detalle) {
        Prestamo prestamo = mapaPrestamos.get(codigoPrestamo);
        prestamo.getDetalles().add(detalle);
        detalle.getLibro().actualizarUnidadesDisponibles(-detalle.getCantidad());
    }

    // Método para devolver un préstamo
    public double devolverPrestamo(String codigoPrestamo, Date fechaDevolucion) {
        return mapaPrestamos.values().stream()
                .filter(prestamo -> prestamo.getCodigo().equals(codigoPrestamo))
                .findFirst()
                .map(prestamo -> {
                    prestamo.setFechaEntrega(fechaDevolucion);
                    return prestamo.calcularCosto();
                })
                .orElse(0.0);
    }

    // Método para buscar un préstamo por su código
    public Prestamo buscarPrestamoPorCodigo(String codigo) {
        return mapaPrestamos.get(codigo);
    }

    // Método para mostrar la cantidad de libros prestados por cada bibliotecario
    public Map<Bibliotecario, Integer> cantidadLibrosPrestadosPorBibliotecario() {
        return mapaPrestamos.values().stream()
                .collect(Collectors.toMap(
                        Prestamo::getBibliotecario,
                        prestamo -> prestamo.getDetalles().size(),
                        Integer::sum
                ));
    }

    // Método para obtener el estudiante con más préstamos
    public Estudiante estudianteConMasPrestamos() {
        return mapaPrestamos.values().stream()
                .collect(Collectors.groupingBy(Prestamo::getEstudiante, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Método para calcular el total de dinero recaudado por la biblioteca
    public double totalDineroRecaudado() {
        return mapaPrestamos.values().stream()
                .mapToDouble(Prestamo::calcularCosto)
                .sum();
    }

    // Método para calcular el total de dinero a pagar a los bibliotecarios
    public double totalDineroAPagarBibliotecarios() {
        return listaBibliotecarios.stream()
                .mapToDouble(bibliotecario -> {
                    double salarioBase = bibliotecario.getSalario();
                    double comision = mapaPrestamos.values().stream()
                            .filter(prestamo -> prestamo.getBibliotecario().equals(bibliotecario))
                            .mapToDouble(prestamo -> prestamo.calcularCosto() * 0.2)
                            .sum();
                    int antiguedad = bibliotecario.getAnoIngreso();
                    return salarioBase + comision + (comision * 0.02 * antiguedad);
                })
                .sum();
    }
}
