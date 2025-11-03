package Unidad_9.Actividad2;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Alumno {
    private String nombre;
    private double nota;
    private String curso;
}
