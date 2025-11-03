package Unidad_6.Tp3_Colecciones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Curso> cursos = new HashMap<>();

        Curso c1 = new Curso("Programacion","Lucero");
        Curso c2 = new Curso("Analisis de Datos","Castro");
        Curso c3 = new Curso("Arquitectura y SO","Castro");

        cursos.put("C001",c1);
        cursos.put("C002",c2);
        cursos.put("C003",c3);

        String codigoBuscado = "C002";
        System.out.println("Curso buscado: " + codigoBuscado + " - " + cursos.get(codigoBuscado));


        for (Map.Entry<String,Curso> entry: cursos.entrySet()){
            System.out.println("Codigo: " + entry.getKey() + " - " + entry.getValue());
        }
    }
}
