package Unidad_7.Tp3_Lombok;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductoDTO {

    private String codigo;
    private String nombre;
    private double precio;
}
