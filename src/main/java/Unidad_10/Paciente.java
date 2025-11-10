package Unidad_10;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Paciente extends Base {

    private String nombre;
    private int edad;
    private String obraSocial;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    // 🔹 Relación con historia clínica (uno a uno)
    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private HistoriaClinica historiaClinica;

    // 🔹 Relación con medicamentos (muchos a muchos)
    @ManyToMany
    @JoinTable(
            name = "paciente_medicamento",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> medicamentos;

    // 🔹 Relación con consultas (uno a muchos)
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;
}
