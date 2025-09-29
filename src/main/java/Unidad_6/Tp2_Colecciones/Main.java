package Unidad_6.Tp2_Colecciones;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Producto> productos = new HashSet<>();

        Producto p1= new Producto("ASD-123","Computadora Portatil");
        Producto p2= new Producto("ASD-123","Computadora De Escritorio");
        Producto p3= new Producto("qwe-456","Teclado inalambrico");
        Producto p4= new Producto("zxc-789","Monitor");
        Producto p5= new Producto("qwe-456","Teclado");

        productos.add(p1);
        productos.add(p2); //Mismo codigo que p1
        productos.add(p3);
        productos.add(p4);
        productos.add(p5); //Mismo codigo que p3
        productos.add(p1); //Vuelvo a agregar p1

        for (Producto p: productos){
            System.out.println(p);
        }

    }
}
