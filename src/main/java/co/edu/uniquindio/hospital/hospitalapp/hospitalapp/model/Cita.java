package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDateTime;

public class Cita {
    private String idCita;
    private LocalDateTime fechaHoraCita;
    private Medico medico;
    private Paciente paciente;
    private Estado estado;

    public Cita(String idCita, LocalDateTime fechaHoraCita, Medico medico, Paciente paciente, Estado estado) {
        this.idCita = idCita;
        this.fechaHoraCita = fechaHoraCita;
        this.medico = medico;
        this.paciente = paciente;
        this.estado = estado;
    }


    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(LocalDateTime fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita='" + idCita + '\'' +
                ", fechaHoraCita=" + fechaHoraCita +
                ", medicoId=" + (medico != null ? medico.getId() : "N/A") +
                ", pacienteId=" + (paciente != null ? paciente.getId() : "N/A") +
                ", estado=" + estado +
                '}';
    }

}
