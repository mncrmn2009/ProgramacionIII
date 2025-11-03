package Unidad_9.Actividad3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Lista de productos de ejemplo
        List<Producto> productos = Arrays.asList(
                new Producto("Mouse", "Periféricos", 80.0, 25),
                new Producto("Teclado", "Periféricos", 120.0, 15),
                new Producto("Monitor", "Pantallas", 250.0, 10),
                new Producto("Auriculares", "Audio", 150.0, 30),
                new Producto("Cámara Web", "Periféricos", 95.0, 12),
                new Producto("Parlante", "Audio", 180.0, 8)
        );

        // Filtrar productos con precio > 100 y ordenarlos por precio descendente
        List<Producto> productosCaros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .toList(); // desde Java 16+

        // Mostrar resultado
        System.out.println("Productos con precio mayor a 100 (ordenados por precio descendente):");
        productosCaros.forEach(System.out::println);

        // Agrupar productos por categoría y calcular el stock total
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,                          // agrupamos por categoría
                        Collectors.summingInt(Producto::getStock)        // sumamos el stock de cada grupo
                ));

        System.out.println("\nStock total por categoría:");
        stockPorCategoria.forEach((categoria, stockTotal) ->
                System.out.println("- " + categoria + ": " + stockTotal + " unidades")
        );

        // Generar un String con "nombre - precio" separado por ";"
        String listadoProductos = productos.stream()
                .map(p -> p.getNombre() + " - $" + p.getPrecio()) // transformamos cada producto a texto
                .collect(Collectors.joining("; ")); // unimos todos separados por "; "

        System.out.println("\nListado de productos (nombre y precio):");
        System.out.println(listadoProductos);

        // Calcular el precio promedio general
        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);

        System.out.println("\nPrecio promedio general: $" + promedioGeneral);

        // Calcular el precio promedio por categoría
        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("\nPrecio promedio por categoría:");
        promedioPorCategoria.forEach((categoria, promedio) ->
                System.out.println("- " + categoria + ": $" + promedio)
        );

    }

}
