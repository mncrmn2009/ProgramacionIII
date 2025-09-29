package Unidad_8.Actividad_4;

import java.util.List;

public class Util {
    public static <T> void imprimirLista (List<T> lista){
        for (T elemento: lista) {
            System.out.println(elemento);
        }
    }

}
