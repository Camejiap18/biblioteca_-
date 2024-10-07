package co.edu.uniquindio.poo.model;

public class DetallePrestamo {
    
    private Libro libro;
    private int cantidad;
    private double subtotal;

    public DetallePrestamo(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }

    private double calcularSubtotal() {
        return cantidad * libro.getPrecio();
    }

    // Getters y Setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
        this.subtotal = calcularSubtotal(); // Recalcular el subtotal al cambiar el libro
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal(); // Recalcular el subtotal al cambiar la cantidad
    }

    public double getSubtotal() {
        return subtotal;
    }

    public static void main(String[] args) {
        // Crear un objeto DetallePrestamo con datos de ejemplo
        Libro libro = new Libro("001", "ISBN001", "Autor1", "Titulo1", "Editorial1", "2023-01-01", 5, 150.0);
        DetallePrestamo detalle = new DetallePrestamo(libro, 2);

        // Mostrar la información del detalle del préstamo
        System.out.println("Libro: " + detalle.getLibro().getTitulo() + ", Cantidad: " + detalle.getCantidad() + ", Subtotal: " + detalle.getSubtotal());
    }
}
