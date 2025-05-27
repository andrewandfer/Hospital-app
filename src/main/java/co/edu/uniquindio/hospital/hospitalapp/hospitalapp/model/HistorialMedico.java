package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.util.LinkedList;

public class HistorialMedico {
    private LinkedList<Medico> colaboradores;
    private String idHistorialMedico;
    private String diagnostico;
    private String tratamiento;
    private Paciente paciente;

    public HistorialMedico(String idHistorialMedico, String diagnostico, String tratamiento, Paciente paciente) {
        this.idHistorialMedico = paciente.getId();
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.paciente = paciente;
    }

    public LinkedList<Medico> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(LinkedList<Medico> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public String getIdHistorialMedico() {
        return idHistorialMedico;
    }

    public void setIdHistorialMedico(String idHistorialMedico) {
        this.idHistorialMedico = idHistorialMedico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

        @Override
        public String toString() {
            return "📋 Historial Médico:\n" +
                    "🆔 ID: " + idHistorialMedico + "\n" +
                    "🧾 Diagnóstico: " + diagnostico + "\n" +
                    "💊 Tratamiento: " + tratamiento + "\n" +
                    "👤 Paciente: " + paciente + "\n";
        }

    }