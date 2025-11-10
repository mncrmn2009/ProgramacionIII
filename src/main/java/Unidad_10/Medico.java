package Unidad_10;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Medico extends Base {

    private String nombre;
    private String especialidad;
    private int matricula;

    // 🔹 Relación con consultas (uno a muchos)
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Consulta> consultas;
}
