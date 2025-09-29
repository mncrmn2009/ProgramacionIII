package Unidad_5.Actividad_3;

public class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + getNombre() + ", edad=" + getEdad()+
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
