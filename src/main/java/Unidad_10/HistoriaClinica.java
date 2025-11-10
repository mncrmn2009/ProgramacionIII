package Unidad_10;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historias_clinicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HistoriaClinica extends Base {

    private String descripcion;

    // 🔹 Relación uno a uno con Paciente
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
