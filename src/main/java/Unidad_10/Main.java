package Unidad_10;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicaPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // 🔹 Médicos
        Medico medico1 = Medico.builder()
                .nombre("Dr. Ramírez")
                .especialidad("Cardiología")
                .matricula(1234)
                .build();

        Medico medico2 = Medico.builder()
                .nombre("Dra. López")
                .especialidad("Clínica General")
                .matricula(5678)
                .build();

        em.persist(medico1);
        em.persist(medico2);

        // 🔹 Medicamentos
        Medicamento medicamento1 = Medicamento.builder().nombre("Paracetamol").descripcion("Analgésico").dosis(500).build();
        Medicamento medicamento2 = Medicamento.builder().nombre("Amoxicilina").descripcion("Antibiótico").dosis(250).build();
        Medicamento medicamento3 = Medicamento.builder().nombre("Ibuprofeno").descripcion("Antiinflamatorio").dosis(400).build();

        em.persist(medicamento1);
        em.persist(medicamento2);
        em.persist(medicamento3);

        // 🔹 Pacientes
        Paciente p1 = Paciente.builder()
                .nombre("Ana Pérez")
                .edad(25)
                .obraSocial("OSDE")
                .fechaNacimiento(LocalDate.of(1999, 3, 10))
                .build();

        Paciente p2 = Paciente.builder()
                .nombre("Juan Gómez")
                .edad(45)
                .obraSocial("Swiss Medical")
                .fechaNacimiento(LocalDate.of(1979, 5, 2))
                .build();

        Paciente p3 = Paciente.builder()
                .nombre("María López")
                .edad(33)
                .obraSocial("OSDE")
                .fechaNacimiento(LocalDate.of(1991, 1, 15))
                .build();

        // Asociar medicamentos a pacientes
        p1.setMedicamentos(Arrays.asList(medicamento1, medicamento3));
        p2.setMedicamentos(Arrays.asList(medicamento2, medicamento2));
        p3.setMedicamentos(Arrays.asList(medicamento1, medicamento2));

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        // 🔹 Historias clínicas
        HistoriaClinica hc1 = HistoriaClinica.builder()
                .descripcion("Paciente con antecedentes alérgicos.")
                .paciente(p1)
                .build();

        HistoriaClinica hc2 = HistoriaClinica.builder()
                .descripcion("Paciente hipertenso, control mensual.")
                .paciente(p2)
                .build();

        em.persist(hc1);
        em.persist(hc2);

        // 🔹 Consultas
        Consulta c1 = Consulta.builder()
                .fecha(LocalDate.of(2024, 5, 10))
                .diagnostico("Gripe leve")
                .observaciones("Reposo por 3 días")
                .paciente(p1)
                .medico(medico2)
                .build();

        Consulta c2 = Consulta.builder()
                .fecha(LocalDate.of(2024, 5, 12))
                .diagnostico("Chequeo general")
                .observaciones("Todo normal")
                .paciente(p2)
                .medico(medico2)
                .build();

        Consulta c3 = Consulta.builder()
                .fecha(LocalDate.of(2024, 6, 2))
                .diagnostico("Dolor de pecho")
                .observaciones("Solicitar estudios cardíacos")
                .paciente(p2)
                .medico(medico1)
                .build();

        Consulta c4 = Consulta.builder()
                .fecha(LocalDate.of(2024, 6, 15))
                .diagnostico("Alergia estacional")
                .observaciones("Prescribir antihistamínico")
                .paciente(p3)
                .medico(medico2)
                .build();

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);

        em.getTransaction().commit();

        System.out.println("\n========= CONSULTAS JPA =========");

//Listar todos los pacientes mayores de 30 años
        List<Paciente> mayores30 = em.createQuery(
                        "SELECT p FROM Paciente p WHERE p.edad > 30", Paciente.class)
                .getResultList();

        System.out.println("\nPacientes mayores de 30 años:");
        mayores30.forEach(p -> System.out.println("- " + p.getNombre() + " (" + p.getEdad() + " años)"));

//Obtener todas las consultas realizadas por un médico específico
        String nombreMedico = "Dra. López";
        List<Consulta> consultasMedico = em.createQuery(
                        "SELECT c FROM Consulta c WHERE c.medico.nombre = :nombre", Consulta.class)
                .setParameter("nombre", nombreMedico)
                .getResultList();

        System.out.println("\nConsultas realizadas por " + nombreMedico + ":");
        consultasMedico.forEach(c -> System.out.println("- " + c.getDiagnostico() + " (" + c.getFecha() + ")"));

//Mostrar todos los medicamentos asociados a un paciente
        String nombrePaciente = "Ana Pérez";
        List<Medicamento> medsPaciente = em.createQuery(
                        "SELECT m FROM Paciente p JOIN p.medicamentos m WHERE p.nombre = :nombre", Medicamento.class)
                .setParameter("nombre", nombrePaciente)
                .getResultList();

        System.out.println("\nMedicamentos asociados a " + nombrePaciente + ":");
        medsPaciente.forEach(m -> System.out.println("- " + m.getNombre() + " (" + m.getDescripcion() + ")"));

// Listar las consultas con su diagnóstico y el nombre del paciente
        List<Object[]> consultasPacientes = em.createQuery(
                        "SELECT c.diagnostico, c.paciente.nombre FROM Consulta c", Object[].class)
                .getResultList();

        System.out.println("\nConsultas con diagnóstico y nombre del paciente:");
        consultasPacientes.forEach(obj ->
                System.out.println("- " + obj[1] + ": " + obj[0])
        );

// Calcular el promedio de edad de los pacientes
        Double promedioEdad = em.createQuery(
                        "SELECT AVG(p.edad) FROM Paciente p", Double.class)
                .getSingleResult();

        System.out.println("\nPromedio de edad de los pacientes: " + promedioEdad.intValue());

//Listar todos los pacientes que tienen una obra social específica
        String obraSocial = "OSDE";
        List<Paciente> pacientesObra = em.createQuery(
                        "SELECT p FROM Paciente p WHERE p.obraSocial = :os", Paciente.class)
                .setParameter("os", obraSocial)
                .getResultList();

        System.out.println("\nPacientes con obra social " + obraSocial + ":");
        pacientesObra.forEach(p -> System.out.println("- " + p.getNombre()));

//Mostrar los médicos y la cantidad de consultas que atendieron
        List<Object[]> consultasPorMedico = em.createQuery(
                        "SELECT m.nombre, COUNT(c) FROM Consulta c JOIN c.medico m GROUP BY m.nombre", Object[].class)
                .getResultList();

        System.out.println("\nMédicos y cantidad de consultas atendidas:");
        consultasPorMedico.forEach(obj ->
                System.out.println("- " + obj[0] + ": " + obj[1] + " consultas")
        );

//Obtener todos los pacientes junto con la descripción de su historia clínica
        List<Object[]> pacientesHistorias = em.createQuery(
                        "SELECT p.nombre, h.descripcion FROM HistoriaClinica h JOIN h.paciente p", Object[].class)
                .getResultList();

        System.out.println("\nPacientes con descripción de historia clínica:");
        pacientesHistorias.forEach(obj ->
                System.out.println("- " + obj[0] + ": " + obj[1])
        );

        System.out.println("\n========= FIN DE CONSULTAS =========");


        em.close();
        emf.close();

        System.out.println("Datos cargados correctamente en la base de datos H2.");
    }
}

