package Unidad_10;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Consulta extends Base {

    private LocalDate fecha;

    private String diagnostico;

    private String observaciones;

    // 🔹 Relación con Paciente (muchas consultas → un paciente)
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // 🔹 Relación con Médico (muchas consultas → un médico)
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}
