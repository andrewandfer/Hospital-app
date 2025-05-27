package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.LinkedList;

import static co.edu.uniquindio.hospital.hospitalapp.hospitalapp.app.HospitalAppApplication.admin;
import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {
    Administrador administrador;
    Paciente paciente;


    @BeforeEach
    void setUp() {
        administrador = new Administrador("Carlos", "Gomez", "admin1");
        paciente = new Paciente("123", "Juan", "Perez", java.time.LocalDate.of(2000, 1, 1));
        administrador.agregarPaciente(paciente);

    }

    @Test
    void eliminarPaciente() {
        assertTrue(administrador.getPacienteAdministrados().contains(paciente));

        // Elimina el paciente
        administrador.eliminarPaciente(paciente);

        // Verifica que ya no está en la lista
        assertFalse(administrador.getPacienteAdministrados().contains(paciente));


    }

    @Test
    void agregarPaciente() {
        Paciente nuevoPaciente = new Paciente("456", "Ana", "Ramirez", java.time.LocalDate.of(1995, 5, 5));
        administrador.agregarPaciente(nuevoPaciente);

        assertTrue(administrador.getPacienteAdministrados().contains(nuevoPaciente));
    }


    @Test
    void eliminarMedico() {
        Medico medico = new Medico("001", "Pedro", "Martinez", "Cardiología", "101", "1234567890", true);
        administrador.agregarMedico(medico);

        assertTrue(administrador.getMedicosAdministrados().contains(medico));

        administrador.eliminarMedico(medico);

        assertFalse(administrador.getMedicosAdministrados().contains(medico));
    }

    @Test
    void agregarMedico() {
        Medico medico = new Medico("002", "Laura", "Suarez", "Pediatría", "102", "9876543210", true);
        administrador.agregarMedico(medico);

        assertTrue(administrador.getMedicosAdministrados().contains(medico));
    }

    @Test
    void actualizarMedico() {
        Medico medico = new Medico("001", "Pedro", "Martinez", "Cardiología", "101", "1234567890", true);
        administrador.agregarMedico(medico);

        // Datos nuevos para actualizar
        String nuevaEspecialidad = "Neurología";
        String nuevoConsultorio = "202";
        Sala nuevaSala = new Sala("S1", "Consulta General", "8", true);
        LinkedList<Horario> nuevoHorario = new LinkedList<>();
        LinkedList<HistorialMedico> nuevoHistorial = new LinkedList<>();

        boolean actualizado = administrador.actualizarMedico(
                medico.getNumLicencia(),
                nuevaEspecialidad,
                nuevoConsultorio,
                nuevaSala,
                nuevoHorario,
                nuevoHistorial
        );

        assertTrue(actualizado);
        assertEquals(nuevaEspecialidad, medico.getEspecialidad());
        assertEquals(nuevoConsultorio, medico.getConsultorio());
        assertEquals(nuevaSala, medico.getSala());
        assertEquals(nuevoHorario, medico.getHorarioMedico());
        assertEquals(nuevoHistorial, medico.getListaHistorialMedico());
    }

    @Test
    void gestionarSalaPorId() {
        Sala sala = new Sala("S1", "Consulta General", "8", true);
        administrador.getSalasAdministradas().add(sala);

        boolean resultado = administrador.gestionarSalaPorId("S1");

        assertTrue(resultado);
        assertFalse(sala.getDisponibilidad());

    }


    @Test
    void eliminarHorarioDeMedico() {
        Medico medico = new Medico("004", "Mario", "García", "Oncología", "104", "3216549870", true);
        administrador.agregarMedico(medico);

        Horario horario = new Horario("Martes", LocalTime.of(12, 30, 1), LocalTime.of(13, 30, 1));
        administrador.agregarHorarioAMedico(medico.getId(), horario);

        assertTrue(medico.getHorarioMedico().contains(horario));
        assertTrue(administrador.getHorariosCreados().contains(horario));

        boolean eliminado = administrador.eliminarHorarioDeMedico(medico.getId(), horario);

        assertTrue(eliminado);
        assertFalse(medico.getHorarioMedico().contains(horario));
        assertFalse(administrador.getHorariosCreados().contains(horario));
    }

    @Test
    void modificarHorarioDeMedico() {
        Medico medico = new Medico("005", "Lucia", "Fernandez", "Ginecología", "105", "5559876543", true);
        administrador.agregarMedico(medico);

        Horario horarioActual = new Horario("Miércoles", LocalTime.of(9, 0), LocalTime.of(12, 0));
        Horario horarioNuevo = new Horario("Miércoles", LocalTime.of(10, 0), LocalTime.of(13, 0));

        administrador.agregarHorarioAMedico(medico.getId(), horarioActual);

        assertTrue(medico.getHorarioMedico().contains(horarioActual));
        assertTrue(administrador.getHorariosCreados().contains(horarioActual));

        boolean modificado = administrador.modificarHorarioDeMedico(medico.getId(), horarioActual, horarioNuevo);

        assertTrue(modificado);
        assertFalse(medico.getHorarioMedico().contains(horarioActual));
        assertTrue(medico.getHorarioMedico().contains(horarioNuevo));
        assertFalse(administrador.getHorariosCreados().contains(horarioActual));
        assertTrue(administrador.getHorariosCreados().contains(horarioNuevo));
    }


    @Test
    void asignarPacienteAMedico() {
        Medico medico = new Medico("006", "Sofia", "Lopez", "Dermatología", "106", "5551234567", true);
        Paciente paciente = new Paciente("789", "Carlos", "Ruiz", java.time.LocalDate.of(1990, 3, 15));
        administrador.agregarMedico(medico);

        administrador.asignarPacienteAMedico(paciente, medico);

        assertTrue(medico.getPacientesAsignados().contains(paciente));
        assertEquals(medico, paciente.getMedicoAsignado());

        // Prueba que no asigna si el médico no está disponible
        Medico medicoNoDisponible = new Medico("007", "Ana", "Torres", "Neurología", "107", "5557654321", false);
        administrador.agregarMedico(medicoNoDisponible);
        Paciente paciente2 = new Paciente("790", "Luis", "Gomez", java.time.LocalDate.of(1985, 7, 20));

        administrador.asignarPacienteAMedico(paciente2, medicoNoDisponible);

        assertFalse(medicoNoDisponible.getPacientesAsignados() != null && medicoNoDisponible.getPacientesAsignados().contains(paciente2));
        assertNull(paciente2.getMedicoAsignado());
    }

    @Test
    void generarReporteCitasPorEstado() {
        Paciente paciente1 = new Paciente("111", "Ana", "Lopez", java.time.LocalDate.of(1992, 2, 2));
        Cita cita1 = new Cita("C1", java.time.LocalDateTime.of(2024, 6, 1, 10, 0), Estado.PENDIENTE);
        Cita cita2 = new Cita("C2", java.time.LocalDateTime.of(2024, 6, 2, 11, 0), Estado.CONFIRMADA);
        paciente1.setCitas(new LinkedList<>());
        paciente1.getCitas().add(cita1);
        paciente1.getCitas().add(cita2);
        administrador.agregarPaciente(paciente1);

        // Captura la salida estándar
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        administrador.generarReporteCitasPorEstado(Estado.PENDIENTE);

        String salida = outContent.toString();

        assertTrue(salida.contains("C1"));
        assertFalse(salida.contains("C2"));

        // Restaura la salida estándar
        System.setOut(System.out);
    }

}