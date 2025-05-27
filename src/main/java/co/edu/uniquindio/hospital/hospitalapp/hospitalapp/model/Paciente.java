package co.edu.uniquindio.hospital.hospitalapp.hospitalapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

public class Paciente extends Persona {
    private HistorialMedico historialMedico;
    private LinkedList<Cita> citas;
    private Medico medicoAsignado;
    private LocalDate fechaNacimiento;

    public Paciente(String nombre, String apellido, String id, LocalDate fechaNacimiento) {
        super(nombre, apellido, id);
        this.historialMedico = null;
        this.fechaNacimiento = fechaNacimiento;
        this.citas = new LinkedList<>();
        this.medicoAsignado = null;
    }


    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }


    public boolean solicitarCita(LocalDateTime fechaHora, String motivo) {
        if (medicoAsignado == null) {
            System.out.println("El paciente no tiene un médico asignado.");
            return false;
        }


        // Generar ID único para la cita
        String idCita = UUID.randomUUID().toString();

        // Crear la nueva cita
        Cita nuevaCita = new Cita(idCita, fechaHora, medicoAsignado, this, Estado.PENDIENTE);

        // Agregar a la lista del paciente
        this.citas.add(nuevaCita);

        System.out.println("Cita solicitada: " + nuevaCita);
        return true;
    }
    public boolean cancelarCitaPorId(String idCita) {
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(idCita) && cita.getEstado() != Estado.CANCELADA) {
                cita.setEstado(Estado.CANCELADA);
                System.out.println("Cita cancelada correctamente.");
                return true;
            }
        }
        System.out.println("No se encontró la cita o ya está cancelada.");
        return false;
    }
    public HistorialMedico consultarHistorialMedico(Paciente paciente) {
       return paciente.getHistorialMedico();

    }


    public void actualizarDatos(String nuevoNombre, String nuevoApellido, LocalDate nuevaFechaNacimiento) {
        if (nuevoNombre != null && !nuevoNombre.isBlank()) {
            setNombre(nuevoNombre);
        }
        if (nuevoApellido != null && !nuevoApellido.isBlank()) {
            setApellido(nuevoApellido);
        }

        if (nuevaFechaNacimiento != null){
            setFechaNacimiento(nuevaFechaNacimiento);
        }

    }


//    @Override
//    public String toString() {
//        return "Paciente{" +
//                ", historialMedico=" + historialMedico +
//                ", citas=" + citas +
//                '}';
//    }

    @Override
    public String toString() {
        return this.getNombre(); // o getNombreCompleto(), o lo que prefieras
    }

    }


