package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void solicitarCita() {
        Paciente paciente = new Paciente("Juan", "Perez", "123", java.time.LocalDate.of(2000, 1, 1));
        Medico medico = new Medico("Ana", "Gomez", "456", "Pediatría", "A1", "LIC001", true);
        paciente.setMedicoAsignado(medico);

        int citasAntes = paciente.getCitas().size();
        LocalDateTime fechaCita = java.time.LocalDateTime.now().plusDays(1);

// Solicitar cita (solo pasa la fecha)
        boolean resultado = paciente.solicitarCita(fechaCita);

        assertTrue(resultado);
        assertEquals(citasAntes + 1, paciente.getCitas().size());
// Verifica que la última cita tiene la fecha correcta
        assertEquals(fechaCita, paciente.getCitas().getLast().getFechaHoraCita());


    }

    @Test
    void consultarHistorialMedico() {
            Paciente paciente = new Paciente("Juan", "Perez", "123", java.time.LocalDate.of(2000, 1, 1));
            HistorialMedico historial = new HistorialMedico("H1", "Sin alergias", "Observaciones", paciente);
            paciente.setHistorialMedico(historial);

            HistorialMedico resultado = paciente.consultarHistorialMedico(paciente);

            assertNotNull(resultado);
            assertEquals(historial, resultado);
    }

    @Test
    void actualizarDatos() {
        Paciente paciente = new Paciente("Juan", "Perez", "123", java.time.LocalDate.of(2000, 1, 1));

        paciente.actualizarDatos("Carlos", "Ramirez", java.time.LocalDate.of(1995, 5, 20));

        assertEquals("Carlos", paciente.getNombre());
        assertEquals("Ramirez", paciente.getApellido());
        assertEquals(java.time.LocalDate.of(1995, 5, 20), paciente.getFechaNacimiento());

        // Prueba que no cambia si se pasan valores nulos o vacíos
        paciente.actualizarDatos(null, "", null);

        assertEquals("Carlos", paciente.getNombre());
        assertEquals("Ramirez", paciente.getApellido());
        assertEquals(java.time.LocalDate.of(1995, 5, 20), paciente.getFechaNacimiento());
    }
}