package Unidad_7.Tp4_Lombok;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Producto {
    private String codigo;
    private String nombre;
    private String proveedor;
    private double precio;

    public Producto(String codigo, String nombre, String proveedor, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
    }

}
