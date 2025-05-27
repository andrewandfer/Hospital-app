package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GestorCitasTest {
    private GestorCitas gestorCitas;
    private Paciente paciente;
    private Medico medico;

    @BeforeEach
    void setUp() {
        gestorCitas = new GestorCitas();
        paciente = new Paciente("Cristian", "Gonzalez", "123456789", LocalDate.of(2006, 7, 22));
        medico = new Medico("Raul", "Gomez", "medico1", "nada", "D401", "000", true);
    }

    @Test
    void solicitarCita() {
        LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 1, 10, 0);
        String idCita = gestorCitas.solicitarCita(paciente, medico, fechaHora);

        assertNotNull(idCita);

        // Buscar la cita recién creada
        Cita cita = gestorCitas.getCitas().stream()
                .filter(c -> c.getIdCita().equals(idCita))
                .findFirst()
                .orElse(null);

        assertNotNull(cita);
        assertEquals(paciente, cita.getPaciente());
        assertEquals(medico, cita.getMedico());
        assertEquals(Estado.PENDIENTE, cita.getEstado());
    }

    @Test
    void cancelarCita() {
            // Crear y agregar una cita
            LocalDateTime fechaHora = LocalDateTime.of(2025, 10, 1, 10, 0);
            String idCita = gestorCitas.solicitarCita(paciente, medico, fechaHora);

            // Cancelar la cita existente
            boolean resultado = gestorCitas.cancelarCita(idCita);
            assertTrue(resultado);

            // Verificar que el estado cambió a CANCELADA
            Cita cita = gestorCitas.getCitas().stream()
                    .filter(c -> c.getIdCita().equals(idCita))
                    .findFirst()
                    .orElse(null);
            assertNotNull(cita);
            assertEquals(Estado.CANCELADA, cita.getEstado());

            // Intentar cancelar una cita inexistente
            boolean resultadoInexistente = gestorCitas.cancelarCita("99999");
            assertFalse(resultadoInexistente);

    }

    @Test
    void validarDatosCita() {

            LocalDateTime fechaFutura = LocalDateTime.now().plusDays(1);
            assertNull(gestorCitas.validarDatosCita(paciente, medico, fechaFutura));

            assertEquals("El paciente no puede ser nulo.", gestorCitas.validarDatosCita(null, medico, fechaFutura));
            assertEquals("El médico no puede ser nulo.", gestorCitas.validarDatosCita(paciente, null, fechaFutura));
            assertEquals("La fecha y hora de la cita deben ser futuras.", gestorCitas.validarDatosCita(paciente, medico, LocalDateTime.now().minusDays(1)));
            assertEquals("La fecha y hora de la cita deben ser futuras.", gestorCitas.validarDatosCita(paciente, medico, null));
        }

    }