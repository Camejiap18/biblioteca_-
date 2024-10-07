package co.edu.uniquindio.poo.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import co.edu.uniquindio.poo.model.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca UQ");

        while (true) {
            System.out.println("Menu de Biblioteca:");
            System.out.println("1. Registrar bibliotecario");
            System.out.println("2. Registrar estudiante");
            System.out.println("3. Registrar libro");
            System.out.println("4. Registrar prestamo");
            System.out.println("5. Devolver prestamo");
            System.out.println("6. Consultar libro por codigo");
            System.out.println("7. Consultar cantidad de prestamos por nombre del libro");
            System.out.println("8. Reemplazar libro");
            System.out.println("9. Mostrar reportes");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("Registrar bibliotecario:");
                    System.out.print("Nombre: ");
                    String nombreBibliotecario = scanner.nextLine();
                    System.out.print("Cedula: ");
                    String cedulaBibliotecario = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefonoBibliotecario = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correoBibliotecario = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salarioBibliotecario = scanner.nextDouble();
                    System.out.print("Año de ingreso: ");
                    int anoIngreso = scanner.nextInt();
                    biblioteca.registrarBibliotecario(nombreBibliotecario, cedulaBibliotecario, telefonoBibliotecario, correoBibliotecario, salarioBibliotecario, anoIngreso);
                    break;
                case 2:
                    System.out.println("Registrar estudiante:");
                    System.out.print("Nombre: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Cedula: ");
                    String cedulaEstudiante = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefonoEstudiante = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correoEstudiante = scanner.nextLine();
                    System.out.print("Notas (separadas por comas): ");
                    String notasStr = scanner.nextLine();
                    String[] notasArray = notasStr.split(",");
                    double[] notas = new double[notasArray.length];
                    for (int i = 0; i < notasArray.length; i++) {
                        notas[i] = Double.parseDouble(notasArray[i]);
                    }
                    biblioteca.registrarEstudiante(nombreEstudiante, cedulaEstudiante, telefonoEstudiante, correoEstudiante, notas);
                    break;
                case 3:
                    System.out.println("Registrar libro:");
                    System.out.print("Codigo: ");
                    String codigoLibro = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbnLibro = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autorLibro = scanner.nextLine();
                    System.out.print("Titulo: ");
                    String tituloLibro = scanner.nextLine();
                    System.out.print("Editorial: ");
                    String editorialLibro = scanner.nextLine();
                    System.out.print("Fecha de publicacion: ");
                    String fechaLibro = scanner.nextLine();
                    System.out.print("Unidades disponibles: ");
                    int unidadesDisponibles = scanner.nextInt();
                    System.out.print("Precio: ");
                    double precioLibro = scanner.nextDouble();
                    biblioteca.registrarLibro(codigoLibro, isbnLibro, autorLibro, tituloLibro, editorialLibro, fechaLibro, unidadesDisponibles, precio);
                    break;
                case 4:
                    System.out.println("Registrar prestamo:");
                    System.out.print("Codigo del prestamo: ");
                    String codigoPrestamo = scanner.nextLine();
                    System.out.print("Cedula del estudiante: ");
                    String cedulaPrestamoEstudiante = scanner.nextLine();
                    Estudiante estudiante = biblioteca.buscarEstudiantePorCedula(cedulaPrestamoEstudiante);
                    if (estudiante == null) {
                        System.out.println("Estudiante no encontrado.");
                        break;
                    }
                    List<DetallePrestamo> detallesPrestamo = new ArrayList<>();
                    while (true) {
                        System.out.print("Codigo del libro (o 'fin' para terminar): ");
                        String codigoLibroPrestamo = scanner.nextLine();
                        if (codigoLibroPrestamo.equals("fin")) break;
                        Libro libro = biblioteca.buscarLibroPorCodigo(codigoLibroPrestamo);
                        if (libro == null) {
                            System.out.println("Libro no encontrado.");
                            continue;
                        }
                        System.out.print("Cantidad: ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        detallesPrestamo.add(new DetallePrestamo(libro, cantidad));
                    }
                    biblioteca.registrarPrestamo(codigoPrestamo, estudiante, detallesPrestamo, new Date(), new Date());
                    break;
                case 5:
                    System.out.println("Devolver prestamo:");
                    System.out.print("Codigo del prestamo: ");
                    String codigoDevolucion = scanner.nextLine();
                    double costo = biblioteca.devolverPrestamo(codigoDevolucion, new Date());
                    System.out.println("Costo del prestamo: " + costo);
                    break;
                case 6:
                    System.out.println("Consultar libro por codigo:");
                    System.out.print("Codigo del libro: ");
                    String codigoConsultaLibro = scanner.nextLine();
                    Libro libroConsultado = biblioteca.buscarLibroPorCodigo(codigoConsultaLibro);
                    if (libroConsultado != null) {
                        System.out.println("Datos del libro: " + libroConsultado.getTitulo() + ", Autor: " + libroConsultado.getAutor());
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Consultar cantidad de prestamos por nombre del libro:");
                    System.out.print("Nombre del libro: ");
                    String nombreLibroPrestamos = scanner.nextLine();
                    int cantidadPrestamos = biblioteca.buscarCantidadPrestamosPorNombre(nombreLibroPrestamos);
                    System.out.println("Cantidad de prestamos del libro " + nombreLibroPrestamos + ": " + cantidadPrestamos);
                    break;
                case 8:
                    System.out.println("Reemplazar libro:");
                    System.out.print("Codigo del libro a reemplazar: ");
                    String codigoLibroReemplazar = scanner.nextLine();
                    System.out.print("Nuevo ISBN: ");
                    String nuevoIsbn = scanner.nextLine();
                    System.out.print("Nuevo autor: ");
                    String nuevoAutor = scanner.nextLine();
                    System.out.print("Nuevo titulo: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Nueva editorial: ");
                    String nuevaEditorial = scanner.nextLine();
                    System.out.print("Nueva fecha de publicacion: ");
                    String nuevaFecha = scanner.nextLine();
                    System.out.print("Nuevas unidades disponibles: ");
                    int nuevasUnidades = scanner.nextInt();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    Libro nuevoLibro = new Libro(codigoLibroReemplazar, nuevoIsbn, nuevoAutor, nuevoTitulo, nuevaEditorial, nuevaFecha, nuevasUnidades, nuevoPrecio);
                    biblioteca.reemplazarLibro(codigoLibroReemplazar, nuevoLibro);
                    break;
                case 9:
                    System.out.println("Mostrar reportes:");
                    Estudiante estudianteConMasPrestamos = biblioteca.estudianteConMasPrestamos();
                    System.out.println("Estudiante con más prestamos: " + estudianteConMasPrestamos.getNombre());

                    double totalDineroRecaudado = biblioteca.totalDineroRecaudado();
                    System.out.println("Total de dinero recaudado: " + totalDineroRecaudado);

                    double totalDineroAPagarBibliotecarios = biblioteca.totalDineroAPagarBibliotecarios();
