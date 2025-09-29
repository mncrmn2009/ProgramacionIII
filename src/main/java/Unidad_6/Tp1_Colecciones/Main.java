package Unidad_6.Tp1_Colecciones;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();

        Alumno a1= new Alumno("Nicolas",7.5);
        Alumno a2= new Alumno("Marcos",8);
        Alumno a3= new Alumno("Rocio",9.5);
        Alumno a4= new Alumno("Angeles", 10);
        Alumno a5= new Alumno("Nicolas",9);

        //Permite duplicados y respeta el orden de insercion
        alumnos.add(a1);
        alumnos.add(a2);
        alumnos.add(a5);
        alumnos.add(a3);
        alumnos.add(a4);


        for (Alumno a: alumnos){
            System.out.println(a);
        }
    }
}

