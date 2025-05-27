package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorarioTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testToString() {
        Horario horario = new Horario("Lunes", java.time.LocalTime.of(8, 0), java.time.LocalTime.of(12, 0));
        String esperado = "Lunes de 08:00 a 12:00";
        assertEquals(esperado, horario.toString());
    }

    @Test
    void testEquals() {
        Horario horario1 = new Horario("Lunes", java.time.LocalTime.of(8, 0), java.time.LocalTime.of(12, 0));
        Horario horario2 = new Horario("Lunes", java.time.LocalTime.of(8, 0), java.time.LocalTime.of(12, 0));
        Horario horario3 = new Horario("Martes", java.time.LocalTime.of(8, 0), java.time.LocalTime.of(12, 0));
        Horario horario4 = new Horario("Lunes", java.time.LocalTime.of(9, 0), java.time.LocalTime.of(12, 0));

        assertEquals(horario1, horario2); // iguales
        assertNotEquals(horario1, horario3); // diferente día
        assertNotEquals(horario1, horario4); // diferente hora de inicio
        assertNotEquals(horario1, null); // comparación con null
        assertNotEquals(horario1, "otro tipo"); // comparación con otro tipo
    }


}