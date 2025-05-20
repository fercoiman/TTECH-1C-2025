package ar.org.ttech;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Articulo> listaArticulos = new ArrayList<>();
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

//        System.out.print("Ingrese ID: ");
//        int id = sc.nextInt();
//        sc.nextLine();
//
//        if (existeArticulo(id)) {
//            System.out.println("*******************************");
//            System.out.println("****** El ID ya existe! *******");
//            System.out.println("*******************************");
//            return;
//        }
//        if (id < 0) {
//            System.out.println("El ID no puede ser negativo!.");
//            return;
//        }

        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese Descripcion: ");
        String descripcion = sc.nextLine();
        boolean preciovalido = false;
        double precio = 0;

        while (!preciovalido) {
            System.out.print("Ingrese Precio: ");

            if (sc.hasNextDouble()) {
                precio = sc.nextDouble();
                sc.nextLine();
                preciovalido = true;
            } else {
                System.out.println("Se debe ingresar un numero!");
                sc.nextLine();
            }
        }
        int id = Main.listaArticulos.size() + 1;
        for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                id = id + 1;
            }
        }

        Articulo nuevoArticulo = new Articulo(id, nombre, descripcion, precio);

        listaArticulos.add(nuevoArticulo);
        System.out.println("*******************************");
        System.out.println("Artículo agregado Correctamente");
        nuevoArticulo.mostrar(id);
        System.out.println("*******************************");

    }


    public static void listarArticulos() {
        if (listaArticulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            for (Articulo a : listaArticulos) {
                a.mostrar();
            }
        }
    }


    public static void modificarArticulo() {
        System.out.print("ID del artículo a modificar: ");
        int id = sc.nextInt();
        for (Articulo articulo : listaArticulos) {
            if (articulo.getId() == id) {
                System.out.print("Nuevo nombre: ");
                articulo.setNombre(sc.nextLine());
                System.out.print("Nueva Descripcion: ");
                articulo.setDescripcion(sc.nextLine());
                System.out.print("Nuevo precio: ");
                articulo.setPrecio(sc.nextDouble());
                System.out.println("Artículo actualizado.");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    public static void eliminarArticulo() {

        System.out.print("ID del artículo a eliminar: ");
        int id = sc.nextInt();

        listaArticulos.removeIf(a -> a.getId() == id);
        System.out.println("Artículo eliminado si existía.");
    }

    public static boolean existeArticulo(int id) {
        return listaArticulos.stream().anyMatch(a -> a.getId() == id);
    }

}
