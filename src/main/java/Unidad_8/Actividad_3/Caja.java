package Unidad_8.Actividad_3;

public class Caja <T> {
    private T contenido;

    public void setContenido (T contenido){
        this.contenido = contenido;
    }
    public T getContenido(){
        return contenido;
    }
}
