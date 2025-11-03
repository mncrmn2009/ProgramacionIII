package Unidad_5.Actividad_3;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private List<Estudiante> listaDeEstudiantes = new ArrayList<>();

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getListaDeEstudiantes() {
        return listaDeEstudiantes;
    }

    public void setListaDeEstudiantes(List<Estudiante> listaDeEstudiantes) {
        this.listaDeEstudiantes = listaDeEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso: " + nombre + ", Cantidad de alumnos:" + listaDeEstudiantes.size() + ", Estudiantes: " + listaDeEstudiantes;
    }
}
