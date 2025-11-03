package Unidad_9.Actividad2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Lista de alumnos de ejemplo
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Lucía", 8.5, "Programación"),
                new Alumno("Martín", 6.0, "Base de Datos"),
                new Alumno("Carla", 9.2, "Programación"),
                new Alumno("Diego", 7.0, "Sistemas Operativos"),
                new Alumno("Ana", 5.5, "Base de Datos")
        );

        // Filtrar los alumnos aprobados (nota >= 7)
        // Mapear los nombres a mayúsculas
        // Ordenar alfabéticamente
        // Recoger en una lista
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .toList();

        // Mostrar resultado
        System.out.println("Alumnos aprobados (en mayúsculas y ordenados):");
        aprobados.forEach(System.out::println);

        // Calcular el promedio general de notas
        double promedioGeneral = alumnos.stream()
                .mapToDouble(Alumno::getNota)   // extrae las notas como double
                .average()                      // calcula el promedio
                .orElse(0.0);                   // valor por defecto si la lista está vacía

        System.out.println("\nPromedio general de notas: " + promedioGeneral);

        // Agrupar alumnos por curso
        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

// Mostrar los grupos
        System.out.println("\nAlumnos agrupados por curso:");
        alumnosPorCurso.forEach((curso, lista) -> {
            System.out.println("- " + curso + ":");
            lista.forEach(a -> System.out.println("   " + a.getNombre() + " - Nota: " + a.getNota()));
        });

        // Obtener los 3 mejores promedios (notas más altas)
        List<Alumno> top3 = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed()) // orden descendente
                .limit(3) // tomar los primeros 3
                .toList();

        System.out.println("\nTop 3 mejores promedios:");
        top3.forEach(a ->
                System.out.println(a.getNombre() + " - Nota: " + a.getNota() + " (" + a.getCurso() + ")")
        );
    }
}

