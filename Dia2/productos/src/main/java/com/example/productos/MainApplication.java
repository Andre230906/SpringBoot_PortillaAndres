package com.example.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    private final ProductoService productoService;

    @Autowired
    public MainApplication(ProductoService productoService) {
        this.productoService = productoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nGestión de Productos");
            System.out.println("1. Listar productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    listarProductos();
                    break;
                case 2:
                    agregarProducto(scanner);
                    break;
                case 3:
                    actualizarProducto(scanner);
                    break;
                case 4:
                    eliminarProducto(scanner);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void listarProductos() {
        System.out.println("Listado de productos:");
        productoService.listarProductos().forEach(System.out::println);
    }

    private void agregarProducto(Scanner scanner) {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(0, nombre, precio);
        productoService.agregarProducto(producto);
        System.out.println("Producto agregado.");
    }

    private void actualizarProducto(Scanner scanner) {
        System.out.println("Ingrese el ID del producto a actualizar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese el nuevo nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el nuevo precio:");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(id, nombre, precio);
        productoService.actualizarProducto(producto);
        System.out.println("Producto actualizado.");
    }

    private void eliminarProducto(Scanner scanner) {
        System.out.println("Ingrese el ID del producto a eliminar:");
        int id = scanner.nextInt();
        productoService.eliminarProducto(id);
        System.out.println("Producto eliminado.");
    }
}
