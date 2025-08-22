package Unidad_5.Actividad_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Estudiante e1 = new Estudiante("Juan",20, "Ingenieria en Sistemas");
        Estudiante e2 = new Estudiante("Maria",22,"Diseño grafico");
        Estudiante e3 = new Estudiante("Pedro", 21, "Medicina");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);

        for (Estudiante e : estudiantes){
            System.out.println(e);
        }
    }
}
