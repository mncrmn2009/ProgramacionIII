package Unidad_9.Actividad3;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
}

