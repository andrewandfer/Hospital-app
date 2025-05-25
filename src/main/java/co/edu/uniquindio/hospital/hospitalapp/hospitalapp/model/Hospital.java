package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Hospital {
    private String nombre;
    private String direccion;
    private String nit;
    private LinkedList<Medico> medicosHospital;
    private LinkedList<Administrador>administradoresHospital;
    private LinkedList<Paciente> Pacientes;
    private LinkedList<Horario> HorarioAtencion;
    private LinkedList<Sala> salas;
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
        this.administradoresHospital = new LinkedList<>();
        this.HorarioAtencion = new LinkedList<>();
        this.salas = new LinkedList<>();
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

    public LinkedList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(LinkedList<Sala> salas) {
        this.salas = salas;
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

    public LinkedList<Administrador> getAdministradoresHospital() {
        return administradoresHospital;
    }

    public void setAdministradoresHospital(LinkedList<Administrador> administradoresHospital) {
        this.administradoresHospital = administradoresHospital;
    }

    public LinkedList<Horario> getHorarioAtencion() {
        return HorarioAtencion;
    }

    public void setHorarioAtencion(LinkedList<Horario> horarioAtencion) {
        HorarioAtencion = horarioAtencion;
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
    public boolean actualizarDatosPaciente(String idPaciente, String nuevoNombre, String nuevoApellido, LocalDate nuevaFechaNacimiento) {
        for (Paciente paciente :Pacientes) {
            if (paciente.getId().equals(idPaciente)) {
                paciente.actualizarDatos(nuevoNombre, nuevoApellido, nuevaFechaNacimiento);
                return true;
            }
        }
        return false;
    }

    public boolean registrarNuevoPaciente(String nombre, String apellido, String id, LocalDate fechaNacimiento) {
        // Verifica si ya existe un paciente con ese ID
        for (Paciente paciente : Pacientes) {
            if (paciente.getId().equals(id)) {
                return false; // Ya existe un paciente con ese ID
            }
        }
        Paciente nuevoPaciente = new Paciente(nombre, apellido, id, fechaNacimiento);
        Pacientes.add(nuevoPaciente);
        return true; // Registro exitoso
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


