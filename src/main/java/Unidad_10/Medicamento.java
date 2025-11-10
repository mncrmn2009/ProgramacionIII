package Unidad_10;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "medicamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Medicamento extends Base {

    private String nombre;

    private String descripcion;

    private double dosis; // por ejemplo: 500 mg, 10 ml, etc.

    // 🔹 Relación muchos a muchos con Paciente
    @ManyToMany(mappedBy = "medicamentos")
    private List<Paciente> pacientes;
}
