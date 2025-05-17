package ar.org.ttech;

public class Articulo {


    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    public Articulo(int id, String nombre, String descripcion, double precio) {
        this.id = createNewId();
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


    private int createNewId() {
        int newId = Main.listaArticulos.size();
        return Main.listaArticulos.size() + 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public void mostrar() {
        System.out.println("ID: " + id + " \tNombre: " + nombre + " \tDescripcion: " + descripcion + " \tPrecio: " + precio);
    }

    public void mostrar(int id) {
        System.out.println("ID: \t\t\t" + id + " \nNombre: \t\t" + nombre + " \nDescripcion: \t" + descripcion + " \nPrecio: \t\t" + precio);
    }


}
