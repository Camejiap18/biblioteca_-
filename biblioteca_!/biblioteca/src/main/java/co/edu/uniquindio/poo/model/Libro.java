package co.edu.uniquindio.poo.model;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private String fecha;
    private int unidadesDisponibles;
    private double precio;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, String fecha, int unidadesDisponibles, double precio) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = fecha;
        this.unidadesDisponibles = unidadesDisponibles;
        this.precio = precio;
    }

    // Métodos Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void actualizarUnidadesDisponibles(int cantidad) {
        this.unidadesDisponibles += cantidad;
    }

    public void prestar() {
        unidadesDisponibles--;
    }

    public void devolver() {
        unidadesDisponibles++;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static void main(String[] args) {
        // Crear un objeto Libro con datos de ejemplo
        Libro libro = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 5, 150.0);

        // Mostrar la información del libro
        System.out.println("Código: " + libro.getCodigo() + ", ISBN: " + libro.getIsbn() + ", Autor: " + libro.getAutor() + ", Título: " + libro.getTitulo() + ", Editorial: " + libro.getEditorial() + ", Fecha: " + libro.getFecha() + ", Unidades Disponibles: " + libro.getUnidadesDisponibles() + ", Precio: " + libro.getPrecio());

        // Prestar y devolver el libro para mostrar la actualización de unidades disponibles
        libro.prestar();
        System.out.println("Unidades disponibles después de prestar: " + libro.getUnidadesDisponibles());
        libro.devolver();
        System.out.println("Unidades disponibles después de devolver: " + libro.getUnidadesDisponibles());
    }
}
