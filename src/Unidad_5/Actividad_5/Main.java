package Unidad_5.Actividad_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();

        Producto p1 = new Producto("ABC-123","PC",1000);
        Producto p2 = new Producto("DEF-456","Monitor",200);
        Producto p3 = new Producto("ABC-123","PC-2",1500);

        agregarProductosSinDuplicados(listaProductos,p1);
        agregarProductosSinDuplicados(listaProductos,p2);
        agregarProductosSinDuplicados(listaProductos,p2);

        /*for (Producto p: listaProductos){
            System.out.println(p);
        }*/
        Set<Producto> listaHashProducto = new HashSet<>();

        listaHashProducto.add(p1);
        listaHashProducto.add(p2);
        listaHashProducto.add(p3);
        listaHashProducto.add(p1);

        for (Producto p: listaHashProducto){
            System.out.println(p);
        }

    }
    public static void agregarProductosSinDuplicados (List<Producto> lista, Producto p){
        if (!lista.contains(p)){
            lista.add(p);
        }
    }
}
