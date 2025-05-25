package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDate;
import java.util.LinkedList;

import java.time.LocalTime;
import java.util.Objects;

public class Horario {
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    // Constructor
    public Horario(String dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y Setters
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    // toString
    @Override
    public String toString() {
        return dia + " de " + horaInicio + " a " + horaFin;
    }

    // equals y hashCode para poder comparar horarios
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horario)) return false;
        Horario horario = (Horario) o;
        return Objects.equals(dia, horario.dia) &&
                Objects.equals(horaInicio, horario.horaInicio) &&
                Objects.equals(horaFin, horario.horaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, horaInicio, horaFin);
    }
}


