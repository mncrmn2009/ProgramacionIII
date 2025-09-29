package Unidad_7.Tp1_Lombok;

public class Main {
    public static void main(String[] args) {
        Persona p= new Persona("Nico",32);
        Persona p1= new Persona();

        p1.setNombre("Marcos");
        p1.setEdad(23);

        System.out.println("Nombre: " + p.getNombre() + " Edad: " + p.getEdad());
        System.out.println("Nombre: " + p1.getNombre() + " Edad: " + p1.getEdad());
    }
}
