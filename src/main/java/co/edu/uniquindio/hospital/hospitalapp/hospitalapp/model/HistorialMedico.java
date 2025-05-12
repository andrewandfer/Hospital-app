package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.util.LinkedList;

public class HistorialMedico {
    private LinkedList<Medico> colaboradores;
    private Paciente paciente;
    private String idHistorialMedico;
    private String diagnostico;
    private String tratamiento;
    private String fechaNacimiento;

    public HistorialMedico(String diagnostico, String idHistorialMedico, String tratamiento, String fechaNacimiento, Paciente paciente, LinkedList<Medico> colaboradores) {
        this.colaboradores = this.colaboradores;
        this.diagnostico = diagnostico;
        this.idHistorialMedico = idHistorialMedico;
        this.paciente = this.paciente;
        this.tratamiento = this.tratamiento;
        this.fechaNacimiento = this.fechaNacimiento;
    }

    public LinkedList<Medico> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(LinkedList<Medico> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(String idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    @Override
    public String toString() {
        return "HistorialMedico{" +
                "colaboradores=" + colaboradores +
                ", pacienteId=" + (paciente != null ? paciente.getId() : "N/A") +
                ", idHistorialMedico='" + idHistorialMedico + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

}
