package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

    Hospital hospital;
    Paciente paciente1;
    Paciente paciente2;

    @BeforeEach
    void setUp() {
        paciente1 = new Paciente("Juan", "Perez", "123", LocalDate.of(2000, 1, 1));
        paciente2 = new Paciente("Ana", "Gomez", "456", LocalDate.of(1995, 5, 10));
        // Inicializa el hospital y agrega los pacientes
        hospital = new Hospital("Mi Hospital", "Calle 1", "NIT123", null, null);
        hospital.getPacientes().add(paciente1);
        hospital.getPacientes().add(paciente2);

    }

    @Test
    void buscarPaciente() {
        Paciente resultado = hospital.buscarPaciente("123");
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
    }
    @Test
    void actualizarDatosPaciente() {
        // Actualizar datos de un paciente existente
        boolean actualizado = hospital.actualizarDatosPaciente("123", "Carlos", "Ramirez", LocalDate.of(1999, 2, 2));
        assertTrue(actualizado);
        Paciente pacienteActualizado = hospital.buscarPaciente("123");
        assertNotNull(pacienteActualizado);
        assertEquals("Carlos", pacienteActualizado.getNombre());
        assertEquals("Ramirez", pacienteActualizado.getApellido());
        assertEquals(LocalDate.of(1999, 2, 2), pacienteActualizado.getFechaNacimiento());

        // Intentar actualizar un paciente inexistente
        boolean noActualizado = hospital.actualizarDatosPaciente("999", "Luis", "Lopez", LocalDate.of(2001, 3, 3));
        assertFalse(noActualizado);
    }
    @Test
    void registrarNuevoPaciente() {
        // Registrar un paciente nuevo
        boolean registrado = hospital.registrarNuevoPaciente("Luis", "Lopez", "789", LocalDate.of(2001, 3, 3));
        assertTrue(registrado);
        Paciente pacienteRegistrado = hospital.buscarPaciente("789");
        assertNotNull(pacienteRegistrado);
        assertEquals("Luis", pacienteRegistrado.getNombre());

        // Intentar registrar un paciente con ID existente
        boolean duplicado = hospital.registrarNuevoPaciente("Pedro", "Martinez", "123", LocalDate.of(1990, 1, 1));
        assertFalse(duplicado);
    }


}