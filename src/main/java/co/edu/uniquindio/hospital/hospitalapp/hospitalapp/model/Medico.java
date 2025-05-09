package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.util.LinkedList;

public class Medico extends Persona {

    private String especialidad;
    private String consultorio;
    private String numLicencia;
    private LinkedList<Horario> horarioMedico;
    private LinkedList<HistorialMedico> listaHistorialMedico;
    private Sala sala;
    private boolean disponible;
    private LinkedList<Paciente> pacientesAsignados;

    public Medico(String nombre, String apellido, String id, String especialidad, String consultorio, String numLicencia, Sala sala) {
        super(nombre, apellido, id);
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.numLicencia = numLicencia;
        this.sala = sala;
        this.horarioMedico = new LinkedList<>();
        this.listaHistorialMedico = new LinkedList<>();
        this.disponible = true;
        this.pacientesAsignados = new LinkedList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public LinkedList<Horario> getHorarioMedico() {
        return horarioMedico;
    }

    public void setHorarioMedico(LinkedList<Horario> horarioMedico) {
        ;this.horarioMedico = horarioMedico;
    }

    public LinkedList<HistorialMedico> getListaHistorialMedico() {
        return listaHistorialMedico;
    }

    public void setListaHistorialMedico(LinkedList<HistorialMedico> listaHistorialMedico) {
        this.listaHistorialMedico = listaHistorialMedico;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void agregarHorario(Horario horarioMedico) {
        this.horarioMedico.add(horarioMedico);
    }

    public void agregarHistorial(HistorialMedico historial) {
        this.listaHistorialMedico.add(historial);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void asignarPaciente(Paciente paciente) {
        if (pacientesAsignados == null) {
            pacientesAsignados = new LinkedList<>();
        }
        pacientesAsignados.add(paciente);
    }


    @Override
    public String toString() {
        return "Medico{" +
                "especialidad='" + especialidad + '\'' +
                ", consultorio='" + consultorio + '\'' +
                ", numLicencia='" + numLicencia + '\'' +
                ", horarioMedico=" + horarioMedico +
                ", listaHistorialMedico=" + listaHistorialMedico +
                ", sala=" + sala +
                '}';
    }
}
