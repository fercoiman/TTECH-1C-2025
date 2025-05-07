package ar.org.ttech;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Articulo> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();        // Limpiar buffer del scanner

            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }


    public static void crearArticulo() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: ");
        System.out.println("Descripcion: ");
        String descripcion = sc.nextLine();
        String nombre = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();


        Articulo nuevoArticulo = new Articulo(id, nombre, descripcion, precio);
        try {
            lista.add(nuevoArticulo);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Artículo agregado Correctamente");
    }

    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            for (Articulo a : lista) {
                a.mostrar();   // Llamada polimórfica al método mostrar()
            }
        }
    }


    public static void modificarArticulo() {
        System.out.print("ID del artículo a modificar: ");
        int id = sc.nextInt();
        for (Articulo articulo : lista) {
            if (articulo.getId() == id) {
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                articulo.setNombre(sc.nextLine());
                System.out.println("Nueva Descripcion: ");
                articulo.setDescripcion(sc.nextLine());
                System.out.print("Nuevo precio: ");
                articulo.setPrecio(sc.nextDouble());
                // Usar setter para cambiar precio
                System.out.println("Artículo actualizado.");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

        public static void eliminarArticulo() {
        System.out.print("ID del artículo a eliminar: ");
        int id = sc.nextInt();
            lista.removeIf(a -> a.getId() == id);
        System.out.println("Artículo eliminado si existía.");
    }

}
