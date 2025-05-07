package ar.org.ttech;

public class Articulo {


    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    public Articulo(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

    }


    public void mostrar() {
        System.out.println("ID: " + id + " Nombre: " + nombre + " Descripcion: " + descripcion + " Precio: " + precio);
    }


}
