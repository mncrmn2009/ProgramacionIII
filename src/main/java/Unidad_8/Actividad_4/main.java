package Unidad_8.Actividad_4;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<String> listaCadenas = new ArrayList<>();
        listaCadenas.add("Hola");
        listaCadenas.add("mundo");
        listaCadenas.add("JAVA");

        List<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(1);
        listaEnteros.add(2);
        listaEnteros.add(3);

        Util.imprimirLista(listaCadenas);
        System.out.println("___");
        Util.imprimirLista(listaEnteros);
    }
}
