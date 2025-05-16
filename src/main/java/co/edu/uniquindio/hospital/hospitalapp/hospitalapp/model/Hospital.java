package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hospital {
    private String nombre;
    private String direccion;
    private String nit;
    private LinkedList<Medico> medicosHospital;
    private LinkedList<Administrador>administradoresHospital;
    private LinkedList<Paciente> Pacientes;
    private Administrador administrador;
    private GestorCitas gestorCitas;

    public Hospital(String nombre, String direccion, String nit, Administrador administrador, GestorCitas gestorCitas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.medicosHospital = new LinkedList<>();
        this.Pacientes = new LinkedList<>();
        this.administrador = administrador;
        this.gestorCitas = gestorCitas;
    }

    public GestorCitas getGestorCitas() {
        return gestorCitas;
    }

    public void setGestorCitas(GestorCitas gestorCitas) {
        this.gestorCitas = gestorCitas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LinkedList<Medico> getMedicosHospital() {
        return medicosHospital;
    }

    public void setMedicosHospital(LinkedList<Medico> medicosHospital) {
        this.medicosHospital = medicosHospital;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }


    public LinkedList<Paciente> getPacientes() {
        return Pacientes;
    }

    public void setPacientes(LinkedList<Paciente> pacientes) {
        Pacientes = pacientes;
    }

    public void eliminarAdministrador(Administrador administrador) {
        administradoresHospital.remove(administrador);
    }
    public void agregarAdministrador(Administrador administrador) {
        administradoresHospital.add(administrador);
    }
    public void eliminarMedico(Medico medico) {
        medicosHospital.remove(medico);
    }
    public void agregarMedico(Medico medico) {
        medicosHospital.add(medico);
    }
    public boolean actualizarMedico(String numLicencia, String nuevaEspecialidad, String nuevoConsultorio,
                                    Sala nuevaSala, LinkedList<Horario> nuevoHorario,
                                    LinkedList<HistorialMedico> nuevoHistorial) {
        for (Medico medico : medicosHospital) {
            if (medico.getNumLicencia().equals(numLicencia)) {
                medico.setEspecialidad(nuevaEspecialidad);
                medico.setConsultorio(nuevoConsultorio);
                medico.setSala(nuevaSala);
                medico.setHorarioMedico(nuevoHorario);
                medico.setListaHistorialMedico(nuevoHistorial);
                return true;
            }
        }
        return false;
    }



    public Paciente buscarPaciente(String idPaciente) {
        for (Paciente paciente : Pacientes) {
            if (paciente.getId().equals(idPaciente)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nit='" + nit + '\'' +
                ", medicosHospital=" + medicosHospital +
                ", administradoresHospital=" + administradoresHospital +
                ", Pacientes=" + Pacientes +
                ", administrador=" + administrador +
                ", gestorCitas=" + gestorCitas +
                '}';
    }
}



