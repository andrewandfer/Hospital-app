package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {

    @Test
    void agregarHorario() {

        Medico medico = new Medico("Ana", "Gomez", "123", "Pediatría", "A1", "LIC001", true);
        Horario horario = new Horario("Martes", LocalTime.of(4, 32, 5), LocalTime.of(6, 0, 0));

        assertTrue(medico.getHorarioMedico().isEmpty());

        medico.agregarHorario(horario);

        assertEquals(1, medico.getHorarioMedico().size());
        assertTrue(medico.getHorarioMedico().contains(horario));
    }

    @Test
    void agregarHistorial() {
        Medico medico = new Medico("Ana", "Gomez", "123", "Pediatría", "A1", "LIC001", true);
        Paciente paciente = new Paciente("Juan", "Perez", "456", java.time.LocalDate.of(2000, 1, 1));
        HistorialMedico historial = new HistorialMedico("H1", "Diagnóstico", "Tratamiento", paciente);

        assertTrue(medico.getListaHistorialMedico().isEmpty());

        medico.agregarHistorial(historial);

        assertEquals(1, medico.getListaHistorialMedico().size());
        assertTrue(medico.getListaHistorialMedico().contains(historial));
    }

    @Test
    void asignarPaciente() {
            Medico medico = new Medico("Ana", "Gomez", "123", "Pediatría", "A1", "LIC001", true);
            Paciente paciente = new Paciente("Juan", "Perez", "456", java.time.LocalDate.of(2000, 1, 1));

            assertTrue(medico.getPacientesAsignados().isEmpty());

            medico.asignarPaciente(paciente);

            assertEquals(1, medico.getPacientesAsignados().size());
            assertTrue(medico.getPacientesAsignados().contains(paciente));
    }

    @Test
    void obtenerHistorialesPorPaciente() {
            Medico medico = new Medico("Ana", "Gomez", "123", "Pediatría", "A1", "LIC001", true);
            Paciente paciente1 = new Paciente("Juan", "Perez", "456", java.time.LocalDate.of(2000, 1, 1));
            Paciente paciente2 = new Paciente("Maria", "Lopez", "789", java.time.LocalDate.of(1999, 5, 10));

            HistorialMedico historial1 = new HistorialMedico("H1", "Diagnóstico1", "Tratamiento1", paciente1);
            HistorialMedico historial2 = new HistorialMedico("H2", "Diagnóstico2", "Tratamiento2", paciente1);
            HistorialMedico historial3 = new HistorialMedico("H3", "Diagnóstico3", "Tratamiento3", paciente2);

            medico.agregarHistorial(historial1);
            medico.agregarHistorial(historial2);
            medico.agregarHistorial(historial3);

            var historialesPaciente1 = medico.obtenerHistorialesPorPaciente(paciente1);
            assertEquals(2, historialesPaciente1.size());
            assertTrue(historialesPaciente1.contains(historial1));
            assertTrue(historialesPaciente1.contains(historial2));

            var historialesPaciente2 = medico.obtenerHistorialesPorPaciente(paciente2);
            assertEquals(1, historialesPaciente2.size());
            assertTrue(historialesPaciente2.contains(historial3));
    }


    @Test
    void eliminarHorarioConsulta() {
            Medico medico = new Medico("Ana", "Gomez", "123", "Pediatría", "A1", "LIC001", true);
            Horario horario = new Horario("Martes", LocalTime.of(4, 32, 5), LocalTime.of(6, 0, 0));

            medico.agregarHorario(horario);
            assertEquals(1, medico.getHorarioMedico().size());

            boolean eliminado = medico.eliminarHorarioConsulta(horario);

            assertTrue(eliminado);
            assertTrue(medico.getHorarioMedico().isEmpty());

    }
}