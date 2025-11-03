package Unidad_8.Actividad_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Caja<String> cajaDeTexto = new Caja<>();
        cajaDeTexto.setContenido("Hola, Genericos");
        System.out.println(cajaDeTexto.getContenido());

        Caja<Integer> cajaDeNumeros = new Caja<>();
        cajaDeNumeros.setContenido(123);
        System.out.println(cajaDeNumeros.getContenido());

        List lista = new ArrayList();

        lista.add ("hola");
        lista.add (123);
        System.out.println(lista);
    }
}
